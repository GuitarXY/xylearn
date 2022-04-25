package com.juc.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterTest {
    static class Person{
        //原子更新age,不能是private 属性 要用volatile修饰
        public volatile Integer age;
    }
    public static void main(String[] args) {
        AtomicReferenceFieldUpdater updater= AtomicReferenceFieldUpdater.newUpdater(Person.class, Integer.class, "age");
        Person person = new Person();
        person.age= 0;
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    boolean b =  updater.compareAndSet(person ,person.age,person.age+1) ;;
                    while (!b){
                        b =  updater.compareAndSet(person ,person.age,person.age+1) ;;
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    boolean b =  updater.compareAndSet(person ,person.age,person.age+1) ;;
                    while (!b){
                        b =  updater.compareAndSet(person ,person.age,person.age+1) ;;
                    }
                }
            }
        };
        t2.start();
        t1.start();
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(person.age);
    }
}
