package com.english.practice.dao;

import com.english.practice.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {

	User get(Integer id);

	int insert(User user);

	int update(User user);

    User getUser(@Param("phone")String phone,@Param("password") String password);

    User selectByNameAndPhone(@Param("phone") String phone);
}