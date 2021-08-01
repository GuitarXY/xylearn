package com.example.xylearn.observer;

public class WxServer implements Observer{
    @Override
    public void callBack() {
        System.out.println("wx receive callback");
    }
}
