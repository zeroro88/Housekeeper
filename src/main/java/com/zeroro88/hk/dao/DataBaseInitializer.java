package com.zeroro88.hk.dao;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.zeroro88.hk.entry.NewsEntry;
import com.zeroro88.hk.entry.User;
import com.zeroro88.hk.mapper.NewsEntryMapper;
import com.zeroro88.hk.mapper.UserMapper;

public class DataBaseInitializer {
	private NewsEntryMapper newsEntryMapper;
	private UserMapper userMapper;

	private PasswordEncoder passwordEncoder;

	protected DataBaseInitializer() {
	}

	public DataBaseInitializer(UserMapper userMapper, NewsEntryMapper newsEntryMapper, PasswordEncoder passwordEncoder) {
		this.userMapper = userMapper;
		this.newsEntryMapper = newsEntryMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void initDataBase() {
		User userUser = new User("user", this.passwordEncoder.encode("user"));
		userUser.addRole("user");
		this.userMapper.save(userUser);

		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.userMapper.save(adminUser);

		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			NewsEntry newsEntry = new NewsEntry();
			newsEntry.setContent("This is example content " + i);
			newsEntry.setDate(new Date(timestamp));
			this.newsEntryMapper.save(newsEntry);
			timestamp += 1000 * 60 * 60;
		}
	}

}