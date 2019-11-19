package com.english.practice.service;

import com.english.practice.entity.Word;

import java.util.List;
import java.util.Map;

public interface WordService {
    int addWords(List<Map<String, String>> works,String classifyId,Integer type);

    List<Word> queryWords(String classifyId,Integer type,Integer page,Integer size, Integer nowPage);

    int addWord(String englishWord, String chinaWord, String classifyId, Integer type);

    Word edit(String wordId);

    int delect(String wordId, Integer isStatus);

    int editWord(String englishWord, String chinaWord, String wordId, Integer type,String classifyId);

    long selectCount(String classifyId);

    List<Word> englishPractice(String classifyId,Integer sum,Integer type);
}
