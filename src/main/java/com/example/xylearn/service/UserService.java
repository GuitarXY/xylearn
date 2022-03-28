package com.example.xylearn.service;

import com.example.xylearn.dao.UserDao;
import com.example.xylearn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiaoy
 * @date 2022/3/28
 */
@Service
public class UserService {
    @Autowired
    private UserService self;
    @Autowired
    private UserDao userDao;

    @Transactional
    public List<User> findAll(){
        return userDao.findAll();
    }
}
