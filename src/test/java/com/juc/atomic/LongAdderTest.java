package com.juc.atomic;

import com.example.xylearn.classloader.DefineClassLoadTest;
import lombok.SneakyThrows;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {
        File file = new File("C:\\Users\\USER\\Desktop\\my");
        URL url = file.toURI().toURL();
        ClassLoader loader=new URLClassLoader(new URL[]{url});
        Class<?> clazz = loader.loadClass("ReentrantLockTest");
        System.out.println("当前类加载器"+clazz.getClassLoader());
        System.out.println("父类加载器"+clazz.getClassLoader().getParent());
        Object o = clazz.newInstance();
        //原子累加操作减少自旋开销
        LongAdder adder = new LongAdder();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    adder.increment();
                }
            }
        };

        Thread t2 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for (int i =0 ; i<1000;i++) {
                    adder.increment();
                }
            }
        };
        t2.start();
        t1.start();
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(adder.sum());

    }
}
