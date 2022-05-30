package com.juc.interrupt;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaoy on 2022/5/19
 */
public class InterruptTest {
    /**
     * Thread
     * interrupt()方法：对目标线程发送中断请求，看其源码会发现最终是调用了一个本地方法实现的线程中断；
     *
     * interrupted()方法：返回目标线程是否中断的布尔值（通过本地方法实现），且返回后会重置中断状态为未中断；
     *
     * isInterrupted()方法：该方法返回的是线程中断与否的布尔值（通过本地方法实现），不会重置中断状态；
     * @param args
     *
     * 线程中断 【1】 运行时中断，【2】阻塞时中断
     * 【1】会在某个取消点中断执行
     * 【2】发生中断时候会立即相应中断 例如join,sleep方法抛出中断异常后会重置线程方法为未中断
     */
    public static void main1(String[] args){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {


        }
        Thread y = new Thread();
        try {
            y.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //lock阻塞中断
        System.out.println("main start");
        Thread thread1 = new Thread(new LockThreadDemo());
        Thread thread2 = new Thread(new LockThreadDemo());
        thread1.start();
        Thread.sleep(1000); // 确保thread1获取到了锁
        thread2.start(); // 此时thread2处于获取锁的阻塞状态
        thread2.interrupt();//thread2还在等待锁，外部main线程对它实行了中断，等thread2获得锁后sleep方法响应了这个中断
        System.out.println("main end");
    }
    public static void main3(String[] args) throws InterruptedException {
        //thread2获取锁的过程中中断(直接判断到了线程处于中断Thread.interrupted() 然后告诉上游)
        System.out.println("main start");
        Thread thread1 = new Thread(new LockThreadInterruptableDemo());
        Thread thread2 = new Thread(new LockThreadInterruptableDemo());
        thread1.start();
        Thread.sleep(1000); // 确保thread1获取到了锁
        thread2.start(); // 此时thread2处于获取锁的阻塞状态
        thread2.interrupt();
        System.out.println("main end");
    }
}

class LockThreadInterruptableDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "runnable run");
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "开始睡眠");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "睡了5秒");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "runnable exception:" + e);
        } finally {
            try {
                lock.unlock();
            } catch (IllegalMonitorStateException e) {
                System.out.println("因线程" + Thread.currentThread().getName() + "提前中断导致未获取到锁");
            }
        }
        System.out.println(Thread.currentThread().getName() + " over");
    }
}
class LockThreadDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "runnable run");
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始睡眠");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "睡了5秒");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "runnable exception:" + e);
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + " over");
    }
}
