package org.service.task.fees;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class ServiceTask {
	Logger log = LoggerFactory.getLogger(ServiceTask.class);

	//@Scheduled(cron="0/20 * * * * ?")
	public void SpringTask() {
		//PushMail.pushText(new TextMail("29506564@qq.com", "测试主题", "测试内容"));
	}

	public void Test163() {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.qiye.163.com");
		senderImpl.setProtocol("smtp");
		senderImpl.setPort(25);
		senderImpl.setUsername("liu.gangqiang@kst-health.com");
		senderImpl.setPassword("puRScDkQmpgeGR4G");
		senderImpl.setDefaultEncoding("UTF-8");

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.timeout", 2500);
		senderImpl.setJavaMailProperties(properties);

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(senderImpl.getUsername());
		smm.setTo("zf29506564@163.com");
		smm.setSubject("163邮箱测试");
		smm.setText("这是通过163邮箱发送的邮件");
		senderImpl.send(smm);
	}

	public void TestQQ() {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.qq.com");
		senderImpl.setProtocol("smtps");
		senderImpl.setPort(465);
		senderImpl.setUsername("mrliugangqiang@vip.qq.com");
		senderImpl.setPassword("qcxeoaucgolybccf");
		senderImpl.setDefaultEncoding("UTF-8");

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.timeout", 2500);
		properties.put("mail.smtp.starttls.enable", true);
		senderImpl.setJavaMailProperties(properties);

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(senderImpl.getUsername());
		smm.setTo(new String[] { "29506564@qq.com" });
		smm.setSubject("QQ邮箱测试");
		smm.setText("这是通过QQ邮箱发送的邮件");
		senderImpl.send(smm);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			// new ServiceTask().Test163();
			new ServiceTask().TestQQ();
		}
	}
}
