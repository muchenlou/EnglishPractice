package com.english.practice.service;

import com.english.practice.entity.Classify;

import java.util.List;

public interface ClassifyService {
    int addClassify(String name, String userId);

    int deleteClassify(String id);

    int updateClassify(String name, String id,String userId);

    List<Classify> queryClassify(String userId);
}
