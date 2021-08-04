package com.example.xylearn.designpattern.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor<T> implements MethodInterceptor {
    T target;

    public MyMethodInterceptor(T target) {
        this.target = target;
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy start");
        return methodProxy.invokeSuper(obj, objects);
    }
}
