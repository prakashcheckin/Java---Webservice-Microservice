package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//execution(* PACKAGE.*.*(..))
	// @Before aspect execute before the method call. It is actually used to check whether user has access to execute the method
	//Pointcuts - * com.in28minutes.rest.webservices.restfulwebservices.user.*.*(..)
	//In Pointcuts first * is for return statement. So intercept for any return statement and  Second * is for intercept for all the class in the user package. Third * is for intercept for all methods in that class. Two dots for any arguments in that methods.
	@Before("execution(* com.in28minutes.spring.aop.springaop.data.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
}
