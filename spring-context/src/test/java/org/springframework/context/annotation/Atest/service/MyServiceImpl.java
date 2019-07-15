package org.springframework.context.annotation.Atest.service;

import org.springframework.stereotype.Service;

/**
 * @Author admin
 * @Data 2019/7/12 14:11
 * @Description
 */
@Service
public class MyServiceImpl implements MyService{
	@Override
	public void tell() {
		System.out.println("老司机要开车");
	}
}
