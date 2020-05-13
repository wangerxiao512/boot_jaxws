package com.nci.tunan.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.nci.tunan.service.UserService;

public class CXFTest {

	public static void main(String[] args) {
		String address = "http://127.0.0.1:8001/soap/user?wsdl";
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setAddress(address);
		jaxWsProxyFactoryBean.setServiceClass(UserService.class);
		UserService us = (UserService)jaxWsProxyFactoryBean.create();
		String userId = "123";
		String result = us.getUserName(userId);
		System.out.println(result);
	}
}
