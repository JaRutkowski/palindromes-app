package com.javafee.springdemo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.javafee.springdemo.entity.Customer;

import lombok.extern.java.Log;

@Log
@Aspect
@Component
public class LoggingAspect {
	@Before("com.javafee.springdemo.aspect.PointcutDeclaration.loggingAllFlow()")
	public void logBefore(JoinPoint joinPoint) {
		StringBuilder stringBuilder = new StringBuilder("calling method: " + joinPoint.getSignature().toShortString() + " ");
		for (Object arg : Arrays.asList(joinPoint.getArgs()))
			stringBuilder.append(arg + " ");
		log.info(stringBuilder.toString());
	}

	@AfterReturning(pointcut = "com.javafee.springdemo.aspect.PointcutDeclaration.loggingAllFlow()",
			returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		StringBuilder stringBuilder = new StringBuilder("calling method: " + joinPoint.getSignature().toShortString() + " ");
		if (result instanceof Customer)
			stringBuilder.append(((Customer) result).getFirstName() + ((Customer) result).getLastName());
		else
			stringBuilder.append(result);
		log.info(stringBuilder.toString());
	}
}
