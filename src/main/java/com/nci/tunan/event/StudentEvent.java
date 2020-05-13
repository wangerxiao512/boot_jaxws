package com.nci.tunan.event;

import org.springframework.context.ApplicationEvent;

import com.nci.tunan.entity.Student;

public class StudentEvent extends ApplicationEvent{
	private Student student;
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentEvent(Object o, Student student) {
		super(o);
		this.student = student;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
