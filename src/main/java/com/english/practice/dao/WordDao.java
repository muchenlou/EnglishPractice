package com.english.practice.dao;

import com.english.practice.entity.Word;

public interface WordDao {

	Word get(Integer id);

	int insert(Word word);

	int update(Word word);

}