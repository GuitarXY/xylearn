package com.example.xylearn.designpattern.proxy;


import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;


public class DynamicProxy {


    public static void main(String[] args) {
        InvocationHandler Handler = new PersonInvocateHandel<>(new PersonInterface() {
            @Override
            public void doSome() {
                System.out.println("interface person");
            }
        });        //创建一个 代理对象 personProxy 来代理 target，创建的代理对象的每个执行方法都会被替换执行Invocation接口中的invoke方法
        //jdk代理只能代理接口
        PersonInterface personProxy = (PersonInterface) Proxy.newProxyInstance(PersonInterface.class.getClassLoader(), new Class<?>[]{PersonInterface.class}, Handler);
        personProxy.doSome();
        personProxy.hashCode();
        personProxy.getClass();


        //cglib代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new MyMethodInterceptor(new Target()));

        Target hello = (Target)enhancer.create();
        hello.doSome();
        hello.hashCode();
        hello.getClass();//不会代理final方法



    }


}
