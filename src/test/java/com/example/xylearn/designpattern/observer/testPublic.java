package com.example.xylearn.designpattern.observer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class testPublic {
    @Test
    public void testPublish(){
        List<Observer> list = new ArrayList<>();
        list.add(new WxServer());
        list.add(new QQObeserver());
        Publish p = new Publish();
        p.setList(list);
        p.publicMessage();
    }
}
