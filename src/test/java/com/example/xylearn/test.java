package com.example.xylearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public char name ='1';
    public void get(){
        System.out.println(name);
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        SocialWechatUser user1= new SocialWechatUser();
        user1.setId(1L);
        user1.setQwxid(1L);
        user1.setNickName("xx");
        SocialWechatUser user2= new SocialWechatUser();
        user2.setId(1L);
        user2.setQwxid(2L);
        user2.setNickName("xx");
        SocialWechatUser user3= new SocialWechatUser();
        user3.setId(1L);
        user3.setQwxid(2L);
        user3.setNickName("xx");
        List<SocialWechatUser> list1 =new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        List<SocialWechatUser> list2 =new ArrayList<>();
        list2.add(user3);
        list1.removeAll(list2);
        System.out.println(list1);
        Class<test> testClass = test.class;
        Method[] methods = testClass.getMethods();
        Class clz = Class.forName("com.example.xylearn.test");
        Method method = clz.getMethod("get");
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        Field name = clz.getField("name");
        char aChar = name.getChar(object);
        System.out.println(aChar);
        method.invoke(object);

    }
}
