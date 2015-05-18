package com.zeroro88.hk.mapper;

import org.apache.ibatis.annotations.Insert;

import com.zeroro88.hk.entry.User;

public interface UserMapper {

	public static final String INSERT = "INSERT INTO USERS VALUES(#{id}, #{name}, #{password})";

	@Insert(INSERT)
	void save(User userUser);

}
