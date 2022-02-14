package com.example.xylearn.netty;

import java.util.concurrent.*;

/**
 * @author xiaoy
 * @date 2022/1/23
 */
public class aa  {
    public static void main(String[] args) {
        ThreadPoolExecutor executors = new ThreadPoolExecutor(1,1,1, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(10));
        executors.shutdownNow();
        executors.execute(new a());
    }
}
class a extends  Thread{
    @Override
    public void run() {
        super.run();
    }
}