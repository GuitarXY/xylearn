package com.juc.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        AtomicReference<Integer> reference = new AtomicReference<Integer>();
        reference.set(0);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    boolean b = reference.compareAndSet(reference.get(), reference.get() + 1);
                    while (!b){
                        b = reference.compareAndSet(reference.get(), reference.get() + 1);
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    boolean b = reference.compareAndSet(reference.get(), reference.get() + 1);
                    while (!b){
                        b = reference.compareAndSet(reference.get(), reference.get() + 1);
                    }
                }
            }
        };
        t2.start();
        t1.start();
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(reference.get());
    }
}
