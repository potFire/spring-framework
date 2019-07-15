package org.springframework.context.annotation.Atest.service;

/**
 * @Author admin
 * @Data 2019/7/12 14:23
 * @Description
 */
public class MyBean {

	public MyBean() {
		System.out.println("MyBean初始化");
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
