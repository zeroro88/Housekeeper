package com.zeroro88.hk.dao;

import java.util.List;

import com.zeroro88.hk.entry.Entity;


public interface Dao<T extends Entity, I>
{

	List<T> findAll();


	T find(I id);


	T save(T newsEntry);


	void delete(I id);

}