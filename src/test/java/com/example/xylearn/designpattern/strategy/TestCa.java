package com.example.xylearn.designpattern.strategy;

import org.junit.jupiter.api.Test;

public class TestCa {
    @Test
    public void doTestCa(){
        Calculator  calculator =null;
        int a = 1;
        if (a == 1){
            calculator = new AddCalcuator();
        }else {
            calculator = new MinCalcuator();
        }
        //用的不同策略
        calculator.doCal();
    }
}
