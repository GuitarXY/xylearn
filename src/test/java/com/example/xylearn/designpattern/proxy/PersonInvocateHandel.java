package com.example.xylearn.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
//自定义的代理类
public class PersonInvocateHandel<T> implements InvocationHandler {

    T target;

    public PersonInvocateHandel(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被动态代理类回调执行, 代理类 proxyClass ="+proxy.getClass()+" 方法名: " + method.getName() + "方法. 方法返回类型："+method.getReturnType()
                +" 接口方法入参数组: "+(args ==null ? "null" : Arrays.toString(args)));        /**
         * 代理过程中插入监测方法,计算该方法耗时
         */
        Thread.sleep(1);        /** 调用被代理对象的真实方法，*/
        Object result = method.invoke(target, args);
        return result;
    }
}
