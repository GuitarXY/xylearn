package com.example.xylearn.threadlocal;

import java.util.concurrent.*;

/**
 * @author xiaoy
 * @date 2022/1/19
 */
public class MemoryLeak {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        executorService.submit(new TestTask());
        Thread.sleep(5000);
        executorService.submit(new TestTask());
    }
}
