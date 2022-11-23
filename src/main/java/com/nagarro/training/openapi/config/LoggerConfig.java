/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Logger provider
 */
@Configuration
public class LoggerConfig {

	/**
	 * Provides a logger according to invoked class
	 * 
	 * @param injectionPoint
	 * @return Logger
	 */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Logger log(InjectionPoint injectionPoint) {

		return LoggerFactory.getLogger(injectionPoint.getMember().getClass());

	}

}
