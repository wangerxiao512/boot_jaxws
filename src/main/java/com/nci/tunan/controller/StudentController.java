package com.nci.tunan.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nci.tunan.service.StudentService;

@RestController
public class StudentController {

	@Resource
	private StudentService studentService;
	
	@GetMapping(name="/student/welcome")
	public void welcomeStudent(){
		studentService.welcomeStudent("1234");
	}
}
