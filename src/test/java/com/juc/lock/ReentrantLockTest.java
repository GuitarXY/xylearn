package com.juc.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static int num = 23;
    static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(ReentrantLockTest::tt, "文化路").start();
        new Thread(ReentrantLockTest::tt, "瑞达路").start();
        new Thread(ReentrantLockTest::tt, "红旗路").start();
    }

    static void tt() {
        String na = Thread.currentThread().getName();

        while (num > 1) {
            lock.lock();
            num--;
            System.out.printf("%s:%d%n", na, num);
            if (num < 1) {
                break;
            }
            lock.unlock();
        }
    }

    public static void main1(String[] args) {
        //响应中断
        Thread a = new Thread(ReentrantLockTest::add, "T1");
        a.start();
        a.interrupt();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {

                lock.lockInterruptibly();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程二");
            lock.unlock();
        }).start();
    }

    static void add() {
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("11");
        lock.unlock();
    }


}
