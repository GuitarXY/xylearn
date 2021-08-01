package com.example.xylearn.designpattern.decorate;

import com.example.xylearn.designpattern.strategy.Calculator;

public class Decorator implements Calculator {
    Calculator calculator = null;

    public Decorator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void doCal() {
        // TODO Auto-generated method stub

        System.out.println("before");
        calculator.doCal();
        System.out.println("after");
    }

}
