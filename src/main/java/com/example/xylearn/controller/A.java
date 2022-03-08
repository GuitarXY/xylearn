package com.example.xylearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class A {
    @Autowired
    @Lazy
    private A a;

    //@Autowired
//    public A(B b) {
//        this.b = b;
//    }

    @Async
    public void getAsync() throws ExecutionException, InterruptedException {
        Future<Integer> t = a.getAsyncA();
        int te = t.get()+1;
        System.out.println(t);
    }

    @Async
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

