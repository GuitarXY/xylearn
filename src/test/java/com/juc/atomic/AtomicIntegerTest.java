package com.juc.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static  AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i =0 ; i<1000000;i++)
                    atomicInteger.incrementAndGet();
            }
        };

        Thread t2 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for (int i =0 ; i<1000000;i++) {
                    atomicInteger.incrementAndGet();
                }
            }
        };
        t2.start();
        t1.start();
       while (Thread.activeCount() > 1){
           Thread.yield();
       }
        System.out.println(atomicInteger);
    }
}
