package com.example.xylearn.classloader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class DefineClassLoadTest extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("ClassLoaderTest1".equals(name)){
            return ClassLoaderTest2.class;
        }
        if ("ClassLoaderTest2".equals(name)){
            return ClassLoaderTest1.class;
        }
        if ("String".equals(name)){
            return LongAdder.class ;
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        DefineClassLoadTest defineClassLoadTest = new DefineClassLoadTest();
        Class<?> classLoaderTest1 = defineClassLoadTest.loadClass("ClassLoaderTest1");
        Object o = classLoaderTest1.newInstance();
        System.out.println(o instanceof ClassLoaderTest2);
        ClassLoaderTest2 classLoaderTest2 = new ClassLoaderTest2();
        System.out.println(classLoaderTest2.getClass().getClassLoader());
//        Map<String,String> map = new HashMap<>();
//        map.put("1","1");
//        map.put("2","2");
//        map.put("3","3");
//        map.entrySet().removeIf(next -> next.getKey().equals("2"));
//        System.out.println(map);
    }
}
class ClassLoaderTest1 {

}
class ClassLoaderTest2 {

}
