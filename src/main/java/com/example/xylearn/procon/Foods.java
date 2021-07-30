package com.example.xylearn.procon;

public class Foods {
    private volatile int index=1;

    public synchronized void produce() throws InterruptedException {
        if (index <= 9) {
            index++;
            System.out.println(Thread.currentThread().getName() + "produce now index" +index );
            notifyAll();
            notifyAll();
        }else {
           System.out.println(Thread.currentThread().getName()+"is wait");
            wait();
        }


    }
    public synchronized void consume() throws InterruptedException {
        if (index > 0){
            index--;
            System.out.println(Thread.currentThread().getName() + "consume now index" + index );
            notifyAll();
        }else {
            System.out.println(Thread.currentThread().getName()+"is wait");
            wait();
        }

    }

    public int getSize() {

        return index;
    }
}
