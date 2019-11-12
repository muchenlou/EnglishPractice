package com.english.practice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Word {
    private String id;
    private String englishWord;
    private String chinaWord;
    private String classifyId;
    /**
     * 状态：-1删除 1、显示 2、已会
     */
    private Integer isStatus;
    /**
     * 类型：1单词 2句子 3作文
     */
    private Integer type;

    private Date newTime;
}
