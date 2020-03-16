package com.ntels.cep.vertx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntels.cep.vertx.VertxServlet;

@Aspect
@Component
public class EventBusAspect {

	@Autowired
	private VertxServlet vertxServlet;
	
	@Around(value = "execution(* **.service.*(..))")
	public Object beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("here");
		return joinPoint.proceed();
	}

	
	
	public void send(ProceedingJoinPoint joinPoint) {
		vertxServlet.getVertx().eventBus().request("service.join.point", joinPoint, result -> {
			
		});
	}
}
