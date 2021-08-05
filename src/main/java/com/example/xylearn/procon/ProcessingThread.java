package com.example.xylearn.procon;

public class ProcessingThread extends Thread {
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println(this.getName()+"neverStop");
        }
    }
}
