package com.example.xylearn.mybatis;

import com.example.xylearn.dao.UserDao;
import com.example.xylearn.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author xiaoy
 * @date 2022/1/18
 */
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class SecondCache {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Test
    public void oneSqlSession() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            UserDao studentMapper = sqlSession.getMapper(UserDao.class);
            // 执行第一次查询
            List<User> students = studentMapper.findAll();
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
            System.out.println("=============开始同一个 Sqlsession 的第二次查询============");
            // 同一个 sqlSession 进行第二次查询
            List<User> stus = studentMapper.findAll();
            for (int i = 0; i < stus.size(); i++) {
                System.out.println("stus:" + stus.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void differSqlSession() {
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            UserDao studentMapper = sqlSession.getMapper(UserDao.class);
            // 执行第一次查询
            List<User> students = studentMapper.findAll();
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
            System.out.println("=============开始不同 Sqlsession 的第二次查询============");
            // 从新创建一个 sqlSession2 进行第二次查询
            sqlSession2 = sqlSessionFactory.openSession();
            UserDao studentMapper2 = sqlSession2.getMapper(UserDao.class);
            List<User> stus = studentMapper2.findAll();
            // 不相等
            assertNotEquals(students, stus);
            for (int i = 0; i < stus.size(); i++) {
                System.out.println("stus:" + stus.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (sqlSession2 != null) {
                sqlSession2.close();
            }
        }
    }


    @Test
    public void sameSqlSessionNoCache() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();

            UserDao studentMapper = sqlSession.getMapper(UserDao.class);
            // 执行第一次查询
            User student = studentMapper.selectByPrimaryKey(1);
            System.out.println("=============开始同一个 Sqlsession 的第二次查询============");
            // 同一个 sqlSession 进行第二次查询
            User stu = studentMapper.selectByPrimaryKey(1);
            assertEquals(student, stu);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
