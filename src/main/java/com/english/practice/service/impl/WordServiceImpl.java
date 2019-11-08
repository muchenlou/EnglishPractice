package com.english.practice.service.impl;

import com.english.practice.dao.WordDao;
import com.english.practice.entity.Word;
import com.english.practice.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordDao wordDao;

    @Override
    public int addWords(List<Map<String, String>> works,String classifyId,Integer type) {
        if (works.size() != 0){
            Word word = new Word();
            word.setType(type);
            word.setClassifyId(classifyId);
            word.setIsStatus(1);
            for (int i = 0;i<works.size();i++){
                Map<String,String> wordMap = works.get(i);
                word.setId(UUID.randomUUID().toString().replace("-",""));
                word.setChinaWord(wordMap.get("englishWord"));
                word.setChinaWord(wordMap.get("chinaWord"));
                wordDao.insert(word);
            }
            return 1;
        }

        return 0;
    }

    @Override
    public List<Word> queryWords(String classifyId,Integer type) {
        return wordDao.queryWordsByType(classifyId,type);
    }
}
