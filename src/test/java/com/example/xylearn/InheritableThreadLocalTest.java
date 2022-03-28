package com.example.xylearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InheritableThreadLocalTest {
    /**
     * InheritableThreadLocal 在创建线程的时候会吧父线程的InheritableThreadLocal 赋值给子线程，但是线程池很少走创建线程的动作
     */
    private static ThreadLocal<Integer> variableHolder = new InheritableThreadLocal() {
         @Override
         protected Integer initialValue() {
                        return 0;
 }
    };
    public int countHighestScoreNodes(int[] parents) {
        int[][] children = new int[parents.length][parents.length];
        for (int i = 0; i < parents.length; i++) {
            int[] child = children[parents[i]];
            for (int j = 0; j < child.length; j++) {
                if (child[j] == 0){
                    child[j] = i;break;
                }
            }
        }
        return getDeep(0);
    }

    private int getDeep(int i) {



        return 0;
    }
    public static int getValue() {
               return variableHolder.get();
    }

          public static void remove() {
                variableHolder.remove();
            }

            public static void increment() {
                variableHolder.set(variableHolder.get() + 1);
            }
    public char name ='1';
    public void get(){
        System.out.println(name);
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        variableHolder.set(0);
        new Thread(()->{
            variableHolder.set(1);
            executor.execute(() -> {

                int before = getValue();

                System.out.println("before: " + before );
            });
        }).start();


        Thread.sleep(10000);
        new Thread(()->{
            variableHolder.set(2);
            executor.execute(() -> {

                int before = getValue();

                System.out.println("before: " + before );
            });
        }).start();

    }
}
