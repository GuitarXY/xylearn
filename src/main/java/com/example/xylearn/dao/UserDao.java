package com.example.xylearn.dao;

import com.example.xylearn.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface UserDao {
    /**
     * 查询所有操作，提供一个方法，返回类型为List类型都是User，叫做findAll
     */
    List<User> findAll();

}