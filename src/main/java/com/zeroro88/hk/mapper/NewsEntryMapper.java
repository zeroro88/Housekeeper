package com.zeroro88.hk.mapper;

import org.apache.ibatis.annotations.Insert;

import com.zeroro88.hk.entry.NewsEntry;


public interface NewsEntryMapper {
	public static final String INSERT = "INSERT INTO newsentry VALUES(#{id}, #{date}, #{content})";
	@Insert(INSERT)
	void save(NewsEntry newsEntry);
	
}
