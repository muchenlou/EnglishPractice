package com.english.practice.service.impl;

import com.english.practice.dao.UserDao;
import com.english.practice.entity.User;
import com.english.practice.service.UserService;
import com.english.practice.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(String name, String phone, String password) {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setName(name);
        user.setIsStatus(1);
        user.setLoginTime(new Date());
        user.setNewTime(new Date());
        user.setPassword(password);
        user.setPhone(phone);
        int insert = 0;
        try {
            user.setPassword(MD5Util.getEncryption(user.getPassword()));
            insert = userDao.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("添加失败");
        }finally {
            return insert;
        }
    }

    @Override
    public User getUser(String name, String password) {
        try {
            password = MD5Util.getEncryption(password);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userDao.getUser(name,password);
    }
}
