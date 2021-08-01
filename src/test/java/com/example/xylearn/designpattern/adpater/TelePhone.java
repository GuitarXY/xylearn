package com.example.xylearn.designpattern.adpater;

import org.junit.jupiter.api.Test;

public class TelePhone extends Watch implements Phone{
    @Override
    public void call() {
        System.out.println("telephone call");
    }

    @Test
    public void testAdapter(){
        //Phone是个适配器
        Phone phone=new TelePhone();
        phone.time();
        phone.call();
    }
}
