package com.nci.tunan.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.nci.tunan.entity.User;
import com.nci.tunan.service.UserService;

@WebService(serviceName="UserService",targetNamespace="http://service.tunan.nci.com",
endpointInterface="com.nci.tunan.service.UserService")
@Component
public class UserServiceImpl implements UserService {

	private Map<String, User> userMap = new HashMap<String, User>();

	public UserServiceImpl(){
		System.out.println("向实体类插入数据");
		User user = new User();
		user.setUserId(UUID.randomUUID().toString().replaceAll("", ""));
		user.setUserName("test1");
		userMap.put(user.getUserId(), user);
		user = new User();
		user.setUserId(UUID.randomUUID().toString().replaceAll("", ""));
		user.setUserName("test2");
		userMap.put(user.getUserId(), user);
		for (Map.Entry<String, User> entry : userMap.entrySet()){
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}
	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userMap.get(userId);
	}

	@Override
	public String getUserName(String userId) {
		// TODO Auto-generated method stub
		return "userId" + userId;
	}
	
	
	
}
