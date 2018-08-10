package org.system.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/10 14:40
 * @return
 * @Description  系统提示语国际化 默认当前语言环境
 **/
public class Prompt {
	private static String filePath = "properties.prompt.prompt_zh_CN";

	/**
	 * <font color="red">无占位符的字符资源</font>
	 * 
	 * @Title bundle
	 * @param key
	 * @return {@linkplain String}
	 * @since 1.0
	 */
	public static String bundle(String key) {
		return ResourceBundle.getBundle(filePath, Locale.getDefault()).getString(key);
	}

	/**
	 * <font color="red">有占位符的字符资源</font>
	 * 
	 * @Title bundle
	 * @param key
	 * @param arguments
	 * @return {@linkplain String}
	 * @since 1.0
	 */
	public static String bundle(String key, Object... arguments) {
		return MessageFormat.format(ResourceBundle.getBundle(filePath, Locale.getDefault()).getString(key), arguments);
	}
}
