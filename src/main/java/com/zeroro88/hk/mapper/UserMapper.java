package com.zeroro88.hk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.zeroro88.hk.entry.User;

public interface UserMapper extends UserDetailsService{

	public static final String INSERT = "INSERT INTO USERS VALUES(#{id}, #{name}, #{password})";
	public static final String SELECT = "SELECT * FROM USERS WHERE NAME =#{name}";

	@Insert(INSERT)
	void save(User userUser);

	@Select(SELECT)
	User findByName(String name);

}
