package com.english.practice.service.impl;

import com.english.practice.dao.LoginSumDao;
import com.english.practice.entity.User;
import com.english.practice.service.LoginSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginSumServiceImpl implements LoginSumService {

    @Autowired
    LoginSumDao loginSumDao;

    @Override
    public int addNotes(User user) {
        return loginSumDao.addNotes(user.getId(),user.getName(),new Date());
    }
}
