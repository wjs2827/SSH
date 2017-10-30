package com.sgl.impl;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgl.service.BaseService;
import com.sgl.util.Base64Util;

@Service("baseService")
@Lazy(true)
@Transactional
public class BaseServiceImpl<T> implements BaseService<T>{
	
	//clazz中存储了当前操作的类型，即泛型T
	private Class clazz;
	
	//注解resource 就不会调用set方法，使用反射注入进来，所以set方法可以去掉
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		//从当前线程获取session，如果没有则创建一个新的session  
		return sessionFactory.getCurrentSession();
	}
	
	public  BaseServiceImpl() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class) type.getActualTypeArguments()[0];
		String fozuStr = "ICAgICAgICAgICAgICAgICAgIF9vb09vb18KICAgICAgICAgICAgICAgICAgbzg4ODg4ODhvCiAgICAgICAgICAgICAgICAgIDg4IiAuICI4OAogICAgICAgICAgICAgICAgICAofCAtXy0gfCkKICAgICAgICAgICAgICAgICAgT1wgID0gIC9PCiAgICAgICAgICAgICAgIF9fX18vYC0tLSdcX19fXwogICAgICAgICAgICAgLicgIFxcfCAgICAgfC8vICBgLgogICAgICAgICAgICAvICBcXHx8fCAgOiAgfHx8Ly8gIFwKICAgICAgICAgICAvICBffHx8fHwgLTotIHx8fHx8LSAgXAogICAgICAgICAgIHwgICB8IFxcXCAgLSAgLy8vIHwgICB8CiAgICAgICAgICAgfCBcX3wgICcnXC0tLS8nJyAgfCAgIHwKICAgICAgICAgICBcICAuLVxfXyAgYC1gICBfX18vLS4gLwogICAgICAgICBfX19gLiAuJyAgLy0tLi0tXCAgYC4gLiBfXwogICAgICAuIiIgJzwgIGAuX19fXF88fD5fL19fXy4nICA+JyIiLgogICAgIHwgfCA6ICBgLSBcYC47YFwgXyAvYDsuYC8gLSBgIDogfCB8CiAgICAgXCAgXCBgLS4gICBcXyBfX1wgL19fIF8vICAgLi1gIC8gIC8KPT09PT09YC0uX19fX2AtLl9fX1xfX19fXy9fX18uLWBfX19fLi0nPT09PT09CiAgICAgICAgICAgICAgICAgICBgPS0tLT0nCl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXl5eXgogICAgICAgICAgICAgICAgIOS9m+elluS/neS9kSAgICAgICDmsLjml6BCVUc=";  
        byte[] decode = null;
		try {
			decode = Base64Util.decodeBase64(fozuStr);
		} catch (Exception e) {
			e.printStackTrace();
		}  
        try {
			System.out.println("\n"+new String(decode,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 新增
	 */
	@Override
	public void save(T o) {
		this.getSession().save(o);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(T o) {
		getSession().update(o);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(String id) {
		System.out.println(clazz.getSimpleName());
		String hql=" delete "+clazz.getSimpleName() + " as c where c.id=:id";
		getSession().createQuery(hql).setString("id",id).executeUpdate();
	}

	/**
	 * 根据id查询
	 */
	@Override
	public T get(String id) {
		return (T) getSession().get(clazz, id);
	}

	/**
	 * 查询列表
	 */
	@Override
	public List<T> query() {
		String hql = " from " + clazz.getSimpleName();
		Query query=getSession().createQuery(hql);
		List<T> list =query.list();
		return list;
	}
	
	

}
