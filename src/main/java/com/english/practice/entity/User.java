package com.english.practice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String name;
    private String password;
    private String phone;
    private Integer isStatus;
    private Date loginTime;
    private Date newTime;
}
