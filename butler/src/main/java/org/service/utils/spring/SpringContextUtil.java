package org.service.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/10 14:44
 * @return
 * @Description Spring Bean工具类
 **/
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param name
	 * @return {@link Object}
	 * @throws BeansException
	 * @version 1.0
	 * @return
	 * @date 2016年1月31日 上午10:51:54
	 * @description 返回Bean实例对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name, Class<T> t) throws BeansException {
		return (T) applicationContext.getBean(name);
	}
}
