package com.english.practice.dao;

import com.english.practice.entity.Classify;

public interface ClassifyDao {

	Classify get(Integer id);

	int insert(Classify classify);

	int update(Classify classify);

}