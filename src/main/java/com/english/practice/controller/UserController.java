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
    public User addUser(@RequestParam String name,@RequestParam  String phone,@RequestParam  String password){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setName(name);
        user.setIsStatus(1);
        user.setLoginTime(new Date());
        user.setNewTime(new Date());
        user.setPassword(password);
        user.setPhone(phone);
        int i = userService.addUser(user);
        if(i == 0){
            return null;
        }
        return user;
    }

    @RequestMapping("/login")
    public User login(@RequestParam  String name,@RequestParam  String password){
        
        return null;
    }
}
