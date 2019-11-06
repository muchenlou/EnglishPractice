package com.english.practice.service.impl;

import com.english.practice.dao.UserDao;
import com.english.practice.entity.User;
import com.english.practice.service.UserService;
import com.english.practice.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
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
}
