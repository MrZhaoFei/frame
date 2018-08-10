package org.system.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.core.result.ResultCode;
import org.core.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

/**
 * @Author Zhao.Fei
 * @Param
 * @Date 2018/8/10 14:40
 * @return
 * @Description 全局异常处理类
 **/
public class ExceptionResolver extends SimpleMappingExceptionResolver {
	Logger log = LoggerFactory.getLogger(ExceptionResolver.class);


	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			/* 非json异常直接跳转页面 */
			if (method.getMethodAnnotation(ResponseBody.class) == null) {
				log.error("Exception ", ex);
				return super.doResolveException(request, response, handler, ex);
			} else {
				ModelAndView mv = new ModelAndView();
				FastJsonJsonView view = new FastJsonJsonView();
				view.setAttributesMap(ResultMap.convertMap(ResultCode.SYSTEM_ERROR, ex.getMessage()));
				mv.setView(view);
				log.error("System Exception cause :", ex);
				return mv;
			}
		}
		return super.doResolveException(request, response, handler, ex);
	}
}