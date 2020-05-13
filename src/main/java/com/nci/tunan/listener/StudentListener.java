package com.nci.tunan.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nci.tunan.event.StudentEvent;

@Component
public class StudentListener {

	@EventListener
	public void sayHello(StudentEvent event){
		System.out.println("[StudentListener] " + event);
	}
}
