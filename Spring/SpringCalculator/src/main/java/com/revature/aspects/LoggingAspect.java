package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(value="within(com.revature.beans.*)", returning="retVal")
	public void logAfter(JoinPoint jp, Integer retVal) {
		log.info(jp.getSignature() + " was called");
		log.info((Integer) jp.getArgs()[0] + " + " + (Integer) jp.getArgs()[1] + " = " + retVal);


	}
	
	@After("execution(int divide())")
	public void logAfterException(JoinPoint jp) {
		log.error(jp.getSignature() + " tried to divide by 0");
	}

}
