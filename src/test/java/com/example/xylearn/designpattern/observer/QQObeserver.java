package com.example.xylearn.designpattern.observer;

public class QQObeserver implements Observer {
    @Override
    public void callBack() {
        System.out.println("qq receive callback");
    }
}
