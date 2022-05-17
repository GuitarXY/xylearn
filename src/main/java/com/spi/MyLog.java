package com.spi;

/**
 * Created by xiaoy on 2022/5/17
 */
public class MyLog implements Log {
    //这个是我们引入依赖的项目,类比为mysqlDriver或者orcleDriver
    @Override
    public void info(String msg) {
        System.out.println("我实现的日志"+msg);
    }
}