package com.example.xylearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class A {
    private B b;

    //@Autowired
    public A(B b) {
        this.b = b;
    }
}

