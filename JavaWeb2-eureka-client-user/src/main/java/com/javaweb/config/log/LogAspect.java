package com.javaweb.config.log;
/**
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.javaweb.constant.SystemConstant;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

@Slf4j
@Aspect
@Component
public class LogAspect {

	@Before(value=SystemConstant.DEFAULT_LOG_POINT_CUT)
	public void beforeMethod(JoinPoint joinPoint) {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("请求地址:").append(httpServletRequest.getRequestURL().toString()).append(",")
		             .append("请求方式:").append(httpServletRequest.getMethod()).append(",")
		             .append("请求类方法:").append(joinPoint.getSignature()).append(",")
		             .append("请求类方法参数:").append(Arrays.toString(joinPoint.getArgs()));
	    //Object obj[] = joinPoint.getArgs();
	    //for(int i=0;i<obj.length;i++) {
	    //    Object o = obj[i];
	    //    try {
	    //        obj[i] = JSONObject.fromObject(o).toString();
	    //    }catch (Exception e) {
        //        //do nothing
        //    }
	    //}
	    log.info(stringBuilder.toString());
	}
	
	@AfterReturning(value=SystemConstant.DEFAULT_LOG_POINT_CUT,returning="object")
	public void afterReturningMethod(Object object) {
		log.info("返回内容:"+JSONObject.fromObject(object).toString());
	}

}
*/