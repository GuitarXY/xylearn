package com.example.xylearn.designpattern.proxy;

import org.junit.jupiter.api.Test;

public class StaticProxy {
    private Target target;
    public void doSome() {
        System.out.println("before do some");
        target.doSome();
        System.out.println("after do some");
    }

    public void setTarget(Target target) {
        this.target = target;
    }


    @Test
    public void testProxy () {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.setTarget(new Target());
        staticProxy.doSome();
    }
}
