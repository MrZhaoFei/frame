package org.core.auth.control;

import org.core.auth.level.Level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/9 15:50
 * @return
 * @Description 安全控制注解，主要适用于基于RBAC模型的鉴权
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiresAuthentication {

	/**
	 * @Author Zhao.Fei
	 * @Param []
	 * @Date 2018/8/9 15:51
	 * @return org.core.auth.level.Level
	 * @Description 控制细粒度（级别）,默认ROLE
	 **/
	Level level() default Level.ROLE;

	/**
	 * @Author Zhao.Fei
	 * @Param []
	 * @Date 2018/8/9 15:51
	 * @return java.lang.String[]
	 * @Description 权限描述值，用于匹配数据库<br>
	 *              建议命名规则：权限等级[:模块][:对象][:操作]<br>
	 *              例如：<br>
	 *              role:user:manager 用户管理角色<br>
	 *              role:user:user:select 用户查询权限<br>
	 *              role:user:user:user:insert 新增用户操作<br>
	 **/
	String[] value();

	/**
	 * @Author Zhao.Fei
	 * @Param []
	 * @Date 2018/8/9 15:51
	 * @return boolean
	 * @Description 是否忽略校验 默认false
	 **/
	boolean ignore() default false;

	/**
	 * @Author Zhao.Fei
	 * @Param []
	 * @Date 2018/8/9 15:52
	 * @return boolean
	 * @Description 是否只做登录鉴权 默认false
	 **/
	boolean authc() default false;
}
