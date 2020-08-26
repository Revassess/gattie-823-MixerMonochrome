package com.revature.dao;

import java.sql.SQLException;
import java.util.Set;

public interface CrudRepository <T>{
	public T save(T t);
	public Set<T> findAll();
	public T findById(Integer id);
	public boolean update(T t);
	public boolean deleteById(Integer id);
	
}