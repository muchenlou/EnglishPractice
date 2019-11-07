package com.english.practice.service.impl;

import com.english.practice.dao.ClassifyDao;
import com.english.practice.entity.Classify;
import com.english.practice.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyDao classifyDao;
    @Override
    public int addClassify(String name, String userId) {
        Classify classify = classifyDao.selectByNameAndUserId(name,userId);
        int i = 0;
        if (classify != null){
            return 0;
        }
        classify = new Classify();
        classify.setId(UUID.randomUUID().toString().replace("-",""));
        classify.setIsStatus(1);
        classify.setName(name);
        classify.setUserId(userId);


        try{
            i = classifyDao.insert(classify);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return i;
        }
    }

    @Override
    public int deleteClassify(String id) {
        return classifyDao.updateIsStatus(id);
    }

    @Override
    public int updateClassify(String name, String id,String userId) {
        Classify classify = classifyDao.selectByNameAndUserId(name, userId);
        if (classify != null){
            return 0;
        }
        return classifyDao.updateByName(name,id);
    }

    @Override
    public List<Classify> queryClassify(String userId) {
        return classifyDao.queryAllClassify(userId);
    }
}
