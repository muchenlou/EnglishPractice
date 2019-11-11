package com.english.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("sigh_in.html")
    public String sighIn(){
        return "sighIn";
    }

}