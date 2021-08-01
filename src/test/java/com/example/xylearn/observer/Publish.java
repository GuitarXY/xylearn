package com.example.xylearn.observer;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Publish {
    List<Observer> list = new ArrayList<>();
//    public Publish(List<Observer> list){
//        this.list= list;
//    }

    public void setList(List<Observer> list) {
        this.list = list;
    }

    public Publish() {
    }

    public void publicMessage(){
        System.out.println("user public message");
        Iterator<Observer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next().callBack();
        }
    }

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
