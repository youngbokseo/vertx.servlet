package com.ntels.cep.common.interceptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SendEventInterceptor extends HandlerInterceptorAdapter  {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(SendEventInterceptor.class);

	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		
		logger.info("interceptor start :::");
//		logger.info(request.get);
		
		

		
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("interceptor end :::");
	}
	
}
