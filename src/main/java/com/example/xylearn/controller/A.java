package com.example.xylearn.controller;

import com.alibaba.excel.EasyExcelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class A {
    @Autowired
    private B a;

    //@Autowired
//    public A(B b) {
//        this.b = b;
//    }

    @Transactional
    public void getAsync() throws ExecutionException, InterruptedException {
//        Future<Integer> t = a.getAsyncA();
//        int te = t.get()+1;
        System.out.println(1);
    }
    public EasyExcelFactory getAsync11() throws ExecutionException, InterruptedException {
//        Future<Integer> t = a.getAsyncA();
//        int te = t.get()+1;
//        System.out.println(t);
        return null;
    }
//    @Async
    public Future<Integer> getAsyncA()  {
        int i = 0;
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<Integer>(33);
    }
}

