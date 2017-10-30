package com.sgl.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sgl.service.UserService;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{
	
	@Autowired
	protected UserService userService;

	private static final long serialVersionUID = 1L;

	protected Map<String,Object> request;
	
	protected Map<String,Object> session;
	
	protected Map<String,Object> application;
	
	protected T model;
	
	@Override
	public void setApplication(Map<String, Object> appication) {
		this.application=appication;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	@Override
	public T getModel() {
		ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
		System.out.println("type:"+type);
		Class clazz=(Class) type.getActualTypeArguments()[0];
		System.out.println("Class:"+clazz);
		try {
			model=(T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		} 
		System.out.println("model:"+model);
		return model;
	} 
	

}  
	
