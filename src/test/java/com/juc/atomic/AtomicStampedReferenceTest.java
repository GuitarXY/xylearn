package com.juc.atomic;

import lombok.SneakyThrows;
import org.assertj.core.api.AtomicReferenceFieldUpdaterAssert;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {
    public static void main(String[] args) {
        //原子类，带版本号
        AtomicStampedReference<Integer> au = new AtomicStampedReference(0,1);
        int a = 0;
        final Integer b =1;
        Thread t1 = new Thread(){
            @Override
            public void run() {

                for (int i =0 ; i<1000;i++) {
                    boolean r =  au.compareAndSet(a,b ,au.getStamp(),au.getStamp()+1) ;
                    while (!r){
                        r =  au.compareAndSet(a,b,au.getStamp(),au.getStamp()+1) ;;
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    boolean r =  au.compareAndSet(b,a ,au.getStamp(),au.getStamp()+1) ;
                    while (!r){
                        r =  au.compareAndSet(b,a,au.getStamp(),au.getStamp()+1) ;;
                    }
                }
            }
        };
        t2.start();
        t1.start();
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(au.getStamp()+"  " + au.getReference());

    }
}
