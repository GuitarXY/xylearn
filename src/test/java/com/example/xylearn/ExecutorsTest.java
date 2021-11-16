package com.example.xylearn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsTest {
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    static class TestThread implements Callable {
        private volatile int i;

        public TestThread(int i) {
            this.i = i;
        }

        @Override
        public Integer call() {
            if (i == 1){
                int j = 1/0;
            }
            i++;
            System.out.println("suc");
            return i;
        }
    }
    public static void main(String[] args) {
        int i = 0;
        TestThread t1 = new TestThread(i);
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
//        new Thread(t1).start();
        fixedThreadPool.submit(t1);
        fixedThreadPool.submit(t1);
        fixedThreadPool.submit(t1);
        fixedThreadPool.submit(t1);
    }
}
