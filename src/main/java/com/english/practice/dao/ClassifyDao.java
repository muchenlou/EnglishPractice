package com.english.practice.dao;

import com.english.practice.entity.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassifyDao {

	Classify get(Integer id);

	int insert(Classify classify);

	int update(Classify classify);

	int updateIsStatus(@Param("id") String id);

	int updateByName(@Param("name")String name,@Param("id") String id);

	List<Classify> queryAllClassify(@Param("userId")String userId);

	Classify selectByNameAndUserId(@Param("name")String name,@Param("userId") String userId);
}