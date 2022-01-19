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

    @Override
    public void run() {
        while (!stop) {
            String formatedDateStr = sdfHolder.get().format(new Date());
            System.out.println("formated date str:" + formatedDateStr);
            //may be sleep for a while to avoid high cpu cost
        }
        sdfHolder.remove();
    }

    //something else
}
