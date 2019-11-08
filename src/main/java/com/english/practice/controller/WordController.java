package com.english.practice.controller;

import com.english.practice.entity.Word;
import com.english.practice.service.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/practice/word")
public class WordController {

    private Logger logger = LoggerFactory.getLogger(WordController.class);

    @Autowired
    private WordService wordService;

    /**
     * 批量添加单词
     * @param works
     * @param classifyId
     * @param type 类型：1单词 2句子 3作文
     * @return
     */
    @RequestMapping("/addWords")
    public boolean addWords(List<Map<String,String>> works, @RequestParam String classifyId,@RequestParam Integer type){
        int i = wordService.addWords(works,classifyId,type);
        if (i == 0){
            return false;
        }
        return true;
    }

    /**
     * 查询
     * @param classifyId
     * @param type
     * @return
     */
    @RequestMapping("/queryWords")
    public List<Word> queryWords(@RequestParam String classifyId,Integer type){
        List<Word> words = wordService.queryWords(classifyId,type);
        return words;
    }
}
