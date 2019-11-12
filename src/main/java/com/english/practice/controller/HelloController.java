package com.english.practice.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    /*
   注册页面
    */
    @RequestMapping("/login")
    public ModelAndView hello(ModelMap map) {
        map.addAttribute("name","欢迎来到小肥的英语练习中心，目前只是开发版");
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    /*
    登录页面
     */
    @RequestMapping(value = "/")
    public String index(){
        return "login";
    }

    /*
   进入注册页面
    */
    @RequestMapping("/sigh_in.html")
    public String sighIn(){
        return "sighIn";
    }

    /*
    添加分类
     */
    @RequestMapping("/addClassify.html")
    public ModelAndView addClassify(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        String userId = session.getAttribute("userId").toString();
        modelAndView.addObject("userId",userId);
        modelAndView.setViewName("addClassify");
        return modelAndView;
    }

    @RequestMapping("/addWord.html")
    public ModelAndView addWord(@RequestParam String classifyId){
        ModelAndView view = new ModelAndView();
        view.addObject("classifyId",classifyId);
        view.setViewName("addWord");
        return view;
    }
}