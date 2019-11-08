package com.english.practice.dao;

import com.english.practice.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordDao {

	Word get(Integer id);

	int insert(Word word);

	int update(Word word);

	List<Word> queryWordsByType(@Param("classifyId") String classifyId,@Param("type") Integer type);
}