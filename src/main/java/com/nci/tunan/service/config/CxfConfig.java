package com.nci.tunan.service.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nci.tunan.service.UserService;

@Configuration
public class CxfConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private UserService userService;
	
	@Bean
	public ServletRegistrationBean dispatcherServlt(){
		return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
	}
	@Bean
	public Endpoint endpoint(){
		EndpointImpl endpoint = new EndpointImpl(bus,userService);
		endpoint.publish("/user");
		return endpoint;
	}
}
