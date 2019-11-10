package com.english.practice.controller;

import com.english.practice.entity.Classify;
import com.english.practice.service.ClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    private Logger logger = LoggerFactory.getLogger(ClassifyController.class);

    /**
     * 新增
     * @param name
     * @param userId
     * @return
     */
    @RequestMapping("/addClassify")
    public boolean addClassify(@RequestParam String name,@RequestParam String userId){
        int i = classifyService.addClassify(name,userId);
        if (i == 0){
            return false;
        }
        return true;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteClassify")
    public boolean deleteClassify(@RequestParam String id){
        int i = classifyService.deleteClassify(id);
        if (i == 0){
            return false;
        }
        return true;
    }

    /**
     * 修改
     * @param name
     * @param userId
     * @return
     */
    @RequestMapping("/updateClassify")
    public boolean updateClassify(@RequestParam String name,@RequestParam String id,@RequestParam String userId){
        int i = classifyService.updateClassify(name,id,userId);
        if (i == 0){
            return false;
        }
        return true;
    }

    /**
     * 查询所有列表
     * @param userId
     * @return
     */
    @RequestMapping("/queryClassify")
    public List<Classify> queryClassify(@RequestParam String userId){
        List<Classify> list = classifyService.queryClassify(userId);
        return list;
    }
}
