package com.english.practice.controller;

import com.english.practice.entity.User;
import com.english.practice.service.LoginSumService;
import com.english.practice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginSumService loginSumService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 添加用户
     * @param name
     * @param phone
     * @param password
     * @return h_baojian
     */
    @RequestMapping("/addUser")
    public int addUser(@RequestParam String name,@RequestParam  String phone,@RequestParam  String password){

        int i = userService.addUser(name,phone,password);
        if(i != 1){
            return i;
        }
        return i;
    }

    /**
     * 登录
     * @param name
     * @param password
     * @param url 进入登录页面前的路径
     * @return
     */
    @PostMapping("/login")
    public User login(@RequestParam  String phone, @RequestParam  String password, String url, HttpServletRequest request){
        User user = userService.getUser(phone,password);
        //记录
        loginSumService.addNotes(user);
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());
        session.setAttribute("name", user.getName());
        session.setAttribute("phone", user.getPhone());
        return user;
    }
}
