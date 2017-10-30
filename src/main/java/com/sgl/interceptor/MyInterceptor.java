package com.sgl.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInterceptor implements Interceptor {

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {
		return false;
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) throws CallbackException {
		return false;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {
		return false;
	}

	@Override
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
			throws CallbackException {
		
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
		
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
		
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
		
	}

	@Override
	public void preFlush(Iterator entities) throws CallbackException {
		
	}

	@Override
	public void postFlush(Iterator entities) throws CallbackException {
		
	}

	@Override
	public Boolean isTransient(Object entity) {
		return null;
	}

	@Override
	public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		return null;
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode, Serializable id) throws CallbackException {
		return null;
	}

	@Override
	public String getEntityName(Object object) throws CallbackException {
		return null;
	}

	@Override
	public Object getEntity(String entityName, Serializable id) throws CallbackException {
		return null;
	}

	@Override
	public void afterTransactionBegin(Transaction tx) {
		System.out.println("开始执行拦截afterTransactionBegin");
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
		System.out.println("开始执行拦截beforeTransactionCompletion");
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
		System.out.println("开始执行拦截afterTransactionCompletion");
	}

	@Override
	public String onPrepareStatement(String sql) {
		return null;
	}

}
