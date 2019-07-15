package org.springframework.context.annotation.Atest.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author admin
 * @Data 2019/7/12 14:12
 * @Description
 */
@Configuration
public class MyConfig {

	@Bean
	public MyBean myBean(){
		return new MyBean();
	}
}
