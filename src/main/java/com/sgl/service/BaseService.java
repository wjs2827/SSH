package com.sgl.service;

import java.util.List;

public interface BaseService<T>{          
	/**
	 * 新增
	 * @param o
	 */
	public void save(T o);
	
	/**
	 * 更新
	 * @param o
	 */
	public void update(T o);
	
	/**
	 * 删除
	 */
	public void delete(String id);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public T get(String id);
	
	/**
	 * 查询列表
	 * @return
	 */
	public List<T> query();


}