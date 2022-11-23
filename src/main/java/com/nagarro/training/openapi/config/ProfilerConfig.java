/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AOP profiler for facade service methods
 */
@Aspect
@Component
public class ProfilerConfig {

	private final Logger log;

	@Autowired
	public ProfilerConfig(Logger log) {
		this.log = log;
	}

	/**
	 * Facade service method profiler
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.nagarro.training.openapi.facade.*.*(..))")
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {

		long startTime = System.currentTimeMillis();

		Object object = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;

		log.info("[{}] [{}] : Completed in {} ms", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(),
				timeTaken);

		return object;

	}

}