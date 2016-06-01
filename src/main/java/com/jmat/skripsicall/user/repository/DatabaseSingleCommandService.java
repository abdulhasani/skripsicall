package com.jmat.skripsicall.user.repository;



import com.jmat.skripsicall.user.entity.User;

import java.io.Serializable;

/**
 * 
 * @author yauritux@gmail.com
 *
 */
public interface DatabaseSingleCommandService<T extends Serializable> {

	public T save(T entity);
	public T save(T entity, User user) throws Exception;
	public boolean delete(T entity);
	public boolean delete(T entity, User user);
	public boolean restore(T entity);
	public boolean restore(T entity, User user);
}
