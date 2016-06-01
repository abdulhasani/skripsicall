package com.jmat.skripsicall.user.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @author yauritux@gmail.com
 *
 */
public interface DatabaseQueryService<T extends Serializable> {

	public T findById(UUID id);
	public List<T> findAll();
}
