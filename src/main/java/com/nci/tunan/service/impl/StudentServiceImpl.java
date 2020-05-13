package com.nci.tunan.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.nci.tunan.entity.Student;
import com.nci.tunan.event.StudentEvent;
import com.nci.tunan.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService ,InitializingBean,DisposableBean{
	
	StudentServiceImpl(){
		System.out.println("--构造------");
	}
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void welcomeStudent(String name) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId("123");
		student.setName("boy");
		applicationContext.publishEvent(new StudentEvent(this, student));
		System.out.println("welcome " + name + " !!!");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---destroy---");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--init-----");
	}

}
