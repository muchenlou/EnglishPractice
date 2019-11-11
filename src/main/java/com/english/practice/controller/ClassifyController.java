package com.english.practice.controller;

import com.english.practice.entity.Classify;
import com.english.practice.entity.User;
import com.english.practice.service.ClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
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
    @ResponseBody
    @RequestMapping("/addClassify")
    public int addClassify(@RequestParam String name,@RequestParam String userId){
        int i = classifyService.addClassify(name,userId);
        if (i == 0){
            return i;
        }
        return i;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
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
    @ResponseBody
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
     * @return
     */
    @RequestMapping("/queryClassify")
    public ModelAndView queryClassify(HttpServletRequest request){
        ModelAndView view = new ModelAndView();
        HttpSession session = request.getSession();
        String userId = session.getAttribute("userId").toString();
        List<Classify> list = classifyService.queryClassify(userId);
        view.setViewName("index");
        view.addObject("list",list);
        return view;
    }

}
