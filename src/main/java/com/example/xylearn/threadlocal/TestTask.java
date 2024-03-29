package com.example.xylearn.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoy
 * @date 2022/1/19
 */
public class TestTask implements Runnable {
    private boolean stop = false;
    private ThreadLocal<SimpleDateFormat> sdfHolder = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static void main(String[] args) {
        Byte o = null;
        byte i =1;
        if (o == i){};
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = sdfHolder.get();
        System.out.println("format" + simpleDateFormat);
//        while (!stop) {
//            SimpleDateFormat simpleDateFormat = sdfHolder.get();
//            System.out.println("format" + simpleDateFormat);
//            String formatedDateStr = sdfHolder.get().format(new Date());
//            System.out.println("formated date str:" + formatedDateStr);
//            //may be sleep for a while to avoid high cpu cost
//        }
//        sdfHolder.remove();
    }

    //something else
}
