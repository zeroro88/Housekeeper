package com.zeroro88.hk.dao.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.zeroro88.hk.dao.Dao;
import com.zeroro88.hk.entry.User;


public interface UserDao extends Dao<User, Long>, UserDetailsService
{

	User findByName(String name);

}