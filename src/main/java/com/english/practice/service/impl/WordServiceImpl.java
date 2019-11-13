package com.english.practice.service.impl;

import com.english.practice.dao.WordDao;
import com.english.practice.entity.Word;
import com.english.practice.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<Word> queryWords(String classifyId,Integer type,Integer page,Integer size, Integer nowPage) {
        return wordDao.queryWordsByType(classifyId,type,page,size);
    }

    @Override
    public int addWord(String englishWord, String chinaWord, String classifyId, Integer type) {
        int i = 2;
        Word word = wordDao.queryWordByClassifyIdAndEnglish(englishWord,classifyId,type);
        if (word != null){
            return i;
        }
        word = new Word();
        word.setChinaWord(chinaWord);
        word.setIsStatus(1);
        word.setClassifyId(classifyId);
        word.setType(type);
        word.setEnglishWord(englishWord);
        word.setNewTime(new Date());
        word.setId(UUID.randomUUID().toString().replace("-",""));
        i = wordDao.insert(word);
        if (i==1){
            return i;
        }
        return 0;
    }

    @Override
    public Word edit(String wordId) {
        Word word = wordDao.edit(wordId);
        return word;
    }

    @Override
    public int delect(String wordId, Integer isStatus) {
        int i = wordDao.editIsStatusAndWordId(wordId,isStatus);
        return i;
    }

    @Override
    public int editWord(String englishWord, String chinaWord, String wordId, Integer type,String classifyId) {
        int i = 2;
        Word word = wordDao.edit(wordId);
        if (word == null){
            return i;
        }
        word.setChinaWord(chinaWord);
        word.setIsStatus(1);
        word.setType(type);
        word.setEnglishWord(englishWord);
        word.setId(wordId);
        i = wordDao.editWord(word);
        if (i==1){
            return i;
        }
        return 0;
    }

    @Override
    public List<Word> englishPractice(String classifyId, Integer sum) {
        //30条英语翻译中文 30条中文翻译英语
        sum = sum / 2;
        List<Word> words = new ArrayList<Word>();
        //英文翻译
        List<Word> w1 = wordDao.PracticeEnglish(classifyId,sum);
        //中文翻译
        List<Word> w2 = wordDao.PracticeChina(classifyId,sum);
        //存入进入list
        words.addAll(w1);
        words.addAll(w2);
        //打乱顺序
        Collections.shuffle(words);
        return words;
    }
}
