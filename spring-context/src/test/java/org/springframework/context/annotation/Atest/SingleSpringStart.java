package org.springframework.context.annotation.Atest;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Atest.service.MyConfig;
import org.springframework.context.annotation.Atest.service.MyServiceImpl;

/**
 * @Author admin
 * @Data 2019/7/12 14:10
 * @Description
 */
public class SingleSpringStart {

	@Test
	public void annotationContextTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class.getPackage().getName());
		MyServiceImpl myService = context.getBean(MyServiceImpl.class);
		myService.tell();
	}
}
