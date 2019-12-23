package com.english.practice.dao;

import com.english.practice.entity.LoginSum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
@Mapper
public interface LoginSumDao {

	LoginSum get(Integer id);

	int insert(LoginSum loginSum);

	int update(LoginSum loginSum);

	int addNotes(@Param("id") String id,@Param("name") String name, @Param("date")Date date);
}