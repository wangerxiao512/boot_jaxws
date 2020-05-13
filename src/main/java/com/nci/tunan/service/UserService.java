package com.nci.tunan.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import javax.jws.WebService;
import com.nci.tunan.entity.User;

@WebService
public interface UserService {

	@WebMethod
	public User getUser(@WebParam(name = "userId") String userId);
	
	@WebMethod
	@WebResult(name = "String",targetNamespace = "")
	public String getUserName(@WebParam(name = "userId") String userId);
}
