package com.example.xylearn.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //ClassLoader in  = int.class.getClassLoader();
        //System.out.println("int is " + in.toString());//g.NullPointerException
       // 因为当前的classloader 的parentclassloader方法没有，
        System.out.println("----------------------------------");
        ClassLoader cl  = cTest.class.getClassLoader();
        System.out.println("cl is " + cl.toString());
        System.out.println("----------------------------------");
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("----------------------------------");
        System.out.println(System.getProperty("java.class.path"));
    }
}
