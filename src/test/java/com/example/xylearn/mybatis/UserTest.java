package com.example.xylearn.mybatis;

import com.alibaba.fastjson.JSON;
import com.example.xylearn.Mapper;
import com.example.xylearn.dao.UserDao;
import com.example.xylearn.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@SpringBootTest
@WebAppConfiguration
@Slf4j

public class UserTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void get() {
        List<User> all = userDao.findAll();
        log.info(JSON.toJSONString(all));

    }
}
