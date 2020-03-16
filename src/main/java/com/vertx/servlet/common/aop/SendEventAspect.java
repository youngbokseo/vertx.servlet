//package com.ntels.cep.common.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ntels.cep.vertx.VertxServlet;
//
//@Aspect
//@Component
//public class SendEventAspect {
//
//	@Autowired
//	private VertxServlet vertxServlet;
//	
//	@Around(value = "execution(*  com.ntels.cep.engine.service.SendEventService(sendEvent))")
//	public Object beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("aop here :::" );
//		return joinPoint.proceed();
//	}
//
//	
//	
//	public void send(ProceedingJoinPoint joinPoint) {
//		vertxServlet.getVertx().eventBus().request("service.join.point", joinPoint, result -> {
//			
//		});
//	}
//}
