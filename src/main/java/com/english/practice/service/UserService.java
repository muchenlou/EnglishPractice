package com.english.practice.service;

import com.english.practice.entity.User;

public interface UserService {

    int addUser(String name, String phone, String password);

    User getUser(String phone, String password);
}
