package com.example.xylearn.mybatis;

import com.example.xylearn.dao.UserDao;
import com.example.xylearn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.*;

public class MyBatisTest {
    private List<List<Integer>> list = new ArrayList<>();
    public boolean book(int start, int end) {
        int i = 0;
        for(;i< list.size();i++){
            List<Integer> li = list.get(i);
            if(li.get(1)>=start){
                break;
            }
        }
        if(i==list.size()-1){
//            if()
            list.add(Arrays.asList(start,end));
            Collections.sort(list, Comparator.comparingInt(o -> o.get(0)));
            return true;
        }else{

            if(end < list.get(i+1).get(0)){
                list.add(Arrays.asList(start,end));
                Collections.sort(list, Comparator.comparingInt(o -> o.get(0)));
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        final User u = new User();
        u.setAddress("xx");
        List<List<Integer>> lis = new ArrayList<>();
        Collections.sort(lis, Comparator.comparingInt(o -> o.get(0)));
        int sta=0;int end = 1;
        if(lis.isEmpty()){
            lis.add(new ArrayList<>(Arrays.asList(sta,end)));
        }else {
            //二分 查找left
//           boolean a = can(0,lis.size(),lis);
        }
        Number n = new Number() {
            @Override
            public int intValue() {
                return 0;
            }

            @Override
            public long longValue() {
                return 0;
            }

            @Override
            public float floatValue() {
                return 0;
            }

            @Override
            public double doubleValue() {
                return 0;
            }
        };
        InputStream in = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> all = userMapper.findAll();
        System.out.println(all);
        session.close();
        Class c = MyBatisTest.class;
        final Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            final Object o = c.newInstance();
        }
    }

    private static boolean can(int s, int e, List<List<Integer>> lis,int sta,int edn) {
        int mid = (s+e)/2;
        final List<Integer> integers = lis.get(mid);//左闭右开
        if (integers.get(0) < sta  ){
            if (integers.get(1) < sta){

            }
        }
        return false;
    }

    public static void ge(int a,Integer b){

        return;
    }
}
