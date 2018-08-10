package org.service.utils.mail;

import java.io.File;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.service.utils.spring.SpringContextUtil;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/10 14:46
 * @return
 * @Description 邮件推送工具类 多线程执行不关心结果
 **/
public class PushMail {
	private static JavaMailSenderImpl mailSender;
	static ExecutorService pool = Executors.newCachedThreadPool();

	static {
		mailSender = SpringContextUtil.getBean("mailSender", JavaMailSenderImpl.class);
	}

	/**
	 * @Author Zhao.Fei
	 * @Param [mail]
	 * @Date 2018/8/10 14:46
	 * @return void
	 * @Description 推送文本格式邮件
	 **/
	public static void pushText(final TextMail mail) {
		pool.execute(new Runnable() {
			@Override
			public void run() {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(mail.getTo());
				message.setFrom(mailSender.getUsername());
				message.setSubject(mail.getSubject());
				message.setText(mail.getText());
				message.setSentDate(new Date());
				mailSender.send(message);
			}
		});
	}

	/**
	 * @Author Zhao.Fei
	 * @Param [mail]
	 * @Date 2018/8/10 14:46
	 * @return void
	 * @Description 推送富文本格式邮件包括附件
	 **/
	public static void pushHtml(final HtmlMail mail) {
		pool.execute(new Runnable() {
			@Override
			public void run() {
				MimeMessage mimeMessage = mailSender.createMimeMessage();
				try {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					helper.setTo(mail.getTo());
					helper.setFrom(mailSender.getUsername());
					helper.setSubject(mail.getSubject());
					helper.setText(mail.getText(), true);
					helper.setSentDate(new Date());
					Set<File> files = mail.getFiles();
					if (files != null) {
						for (File file : files) {
							helper.addAttachment(file.getName(), file);
						}
					}
					mailSender.send(mimeMessage);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
