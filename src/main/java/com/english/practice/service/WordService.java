package com.english.practice.service;

import com.english.practice.entity.Word;

import java.util.List;
import java.util.Map;

public interface WordService {
    int addWords(List<Map<String, String>> works,String classifyId,Integer type);

    List<Word> queryWords(String classifyId,Integer type);
}
