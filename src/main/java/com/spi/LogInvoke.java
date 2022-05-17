package com.spi;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by xiaoy on 2022/5/17
 */
public class LogInvoke {
    //这个是maven引入进来的，类比为调用方项目本身

    public static Log getLog(){
        //类比为driverMAnager的loadInit方法，会去找META-INF/services对应driver的实现类，因为我们引入了mysql包写了ETA-INF/services，就找到了mysql驱动
        Log log = null;
        //因为引入了这个以来，通过serviceLoader类加载器去加载引入以来的模块项目的META-INF/services/目录下面有没有对应的Log.class的实现
        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);
        Iterator<Log> iterator = serviceLoader.iterator();
        if(iterator.hasNext()){
            log = iterator.next();
        }
        return log;
    }
}
