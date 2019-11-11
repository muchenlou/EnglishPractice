package com.english.practice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Classify {
    private String name;
    private String id;
    private String userId;
    private Integer isStatus;
    private Date newTime;
}
