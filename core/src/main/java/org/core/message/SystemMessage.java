package org.core.message;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @ClassName SystemMessage
 * @Author Zhao.Fei
 * @Date 2018/8/9 15:03
 * @Description 国际化资源文件,默认采用本地语言加载对应提示文件内容
 */
public class SystemMessage {

    /**资源提示文件路径*/
    private static String filePath = "org.core.message.system_message";

    /**
     * @Author Zhao.Fei
     * @Param [key]
     * @Date 2018/8/9 15:05
     * @return java.lang.String
     * @Description  无占位符的字符资源
     **/
    public static String bundle(String key) {
        return ResourceBundle.getBundle(filePath, Locale.getDefault()).getString(key);
    }

    /**
     * @Author Zhao.Fei
     * @Param [key, arguments]
     * @Date 2018/8/9 15:07
     * @return java.lang.String
     * @Description 有占位符的字符资源
     **/
    public static String bundle(String key, Object... arguments) {
        return MessageFormat.format(ResourceBundle.getBundle(filePath, Locale.getDefault()).getString(key), arguments);
    }
}
