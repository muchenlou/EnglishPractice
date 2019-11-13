package com.english.practice.controller;

import com.english.practice.entity.Word;
import com.english.practice.service.WordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/word")
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
    @ResponseBody
    @RequestMapping("/addWords")
    public boolean addWords(List<Map<String,String>> works, @RequestParam String classifyId,@RequestParam Integer type){
        int i = wordService.addWords(works,classifyId,type);
        if (i == 0){
            return false;
        }
        return true;
    }

    /**
     * 单个增加单词
     * @param englishWord
     * @param chinaWord
     * @param classifyId
     * @param type 类型：1单词 2句子 3作文
     * @return
     */
    @ResponseBody
    @RequestMapping("/addWord")
    public int addWord(@RequestParam String englishWord,@RequestParam String chinaWord,
                       @RequestParam String classifyId,@RequestParam Integer type){
        int i = wordService.addWord(englishWord,chinaWord,classifyId,type);
        if (i == 0){
            return i;
        }
        return i;
    }


    /**
     * 查询
     * @param classifyId
     * @param type
     * @return
     */
    @RequestMapping("/queryWords")
    public ModelAndView queryWords(@RequestParam String classifyId, Integer type, @RequestParam(defaultValue = "0")Integer page, @RequestParam(defaultValue = "10") Integer size, Integer nowPage){
        List<Word> words = wordService.queryWords(classifyId,type,page,size,nowPage);
        ModelAndView view = new ModelAndView();
        view.setViewName("word");
        view.addObject("words",words);
        view.addObject("classifyId",classifyId);
        view.addObject("page",page);
        view.addObject("size",size);
        view.addObject("nowPage",nowPage);
        view.addObject("count",words.size());
        return view;
    }

    /**
     * 进入修改页面
     * @param wordId
     * @return
     */
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam String wordId){
        ModelAndView view = new ModelAndView();
        Word word = wordService.edit(wordId);
        view.setViewName("editWord");
        view.addObject("word",word);
        return view;
    }

    /**
     * 删除
     * @param wordId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delect")
    public int delect(@RequestParam String wordId,@RequestParam Integer isStatus){
        int i = wordService.delect(wordId,isStatus);
        return i;
    }

    /**
     * 单个修改
     * @param englishWord
     * @param chinaWord
     * @param wordId
     * @param type 类型：1单词 2句子 3作文
     * @return
     */
    @ResponseBody
    @RequestMapping("/editWord")
    public int editWord(@RequestParam String englishWord,@RequestParam String chinaWord,
                       @RequestParam String wordId,@RequestParam Integer type,@RequestParam String classifyId){
        int i = wordService.editWord(englishWord,chinaWord,wordId,type,classifyId);
        if (i == 0){
            return i;
        }
        return i;
    }

    /**
     * 英语练习
     * @param classifyId
     * @param sum
     * @return
     */
    @RequestMapping("/englishPractice")
    public ModelAndView englishPractice(@RequestParam String classifyId,@RequestParam(defaultValue = "60") Integer sum){
        ModelAndView view = new ModelAndView();
        //30条英语翻译中文 30条中文翻译英语
        List<Word> words = wordService.englishPractice(classifyId,sum);
        view.setViewName("practice");
        view.addObject("words",words);
        return view;
    }
}
