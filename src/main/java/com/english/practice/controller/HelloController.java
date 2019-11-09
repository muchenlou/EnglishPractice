package com.english.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/practice")
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView hello(ModelMap map) {
        map.addAttribute("name","欢迎来到小肥的英语练习中心，目前只是开发版");
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    @RequestMapping(value = "/")
    public String index(ModelMap map){
        map.addAttribute("name","欢迎来到小肥的英语练习中心，目前只是开发版");
        return "index";
    }
}