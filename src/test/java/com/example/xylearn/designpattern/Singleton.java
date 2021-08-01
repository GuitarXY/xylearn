package com.example.xylearn.designpattern;

import org.junit.jupiter.api.Test;

public class Singleton {
    /**
     * 单例模式，双重校验锁
     */
    private static volatile Singleton singleton;



    public static Singleton getSingleton() {
        if (singleton == null)
        {
            synchronized(Singleton.class) {      //1
                Singleton inst = singleton;         //2
                if (inst == null)
                {
                    synchronized(Singleton.class) {  //3
                        inst = new Singleton();        //4
                    }
                    singleton = inst;                 //5
                }
            }
        }
        return singleton;
    }

    @Test
    public void getSingl(){
        Singleton s = Singleton.getSingleton();
    }
}
