package com.jmat.skripsicall.user.repository;

import java.util.List;

/**
 * 
 * @author yauritux@gmail.com
 *
 */
public interface DatabaseBatchCommandService<T> {

	public int batchDelete(List<T> entities);
	public int batchRestore(List<T> entities);
}
