package com.example.xylearn.mybatis;

import com.example.xylearn.dao.UserDao;
import com.example.xylearn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> all = userMapper.findAll();
        System.out.println(all);
        session.close();
    }
}
