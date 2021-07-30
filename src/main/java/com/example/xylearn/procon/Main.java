package com.example.xylearn.procon;

public class Main {
    public static void main(String[] args) {
        Foods foods = new Foods();
        Thread t1 = new Producer("p1",foods);
        Thread t2 = new Producer("p2",foods);
        Thread c1 = new Consumer("c1",foods);
        Thread c2 = new Consumer("c2",foods);
        Thread c3 = new Consumer("c3",foods);
        t1.start();
        t2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
