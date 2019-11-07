package com.english.practice.controller;

import com.english.practice.entity.User;
import com.english.practice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/practict/user")
public class UserController {

    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 添加用户
     * @param name
     * @param phone
     * @param password
     * @return h_baojian
     */
    @RequestMapping("/addUser")
    public boolean addUser(@RequestParam String name,@RequestParam  String phone,@RequestParam  String password){

        int i = userService.addUser(name,phone,password);
        if(i == 0){
            return false;
        }
        return true;
    }

    /**
     * 登录
     * @param name
     * @param password
     * @param url 进入登录页面前的路径
     * @return
     */
    @RequestMapping("/login")
    public User login(@RequestParam  String name,@RequestParam  String password,String url){
        User user = userService.getUser(name,password);
        return user;
    }
}
