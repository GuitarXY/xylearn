package com.example.xylearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//@Service
public class B {
    String c;
    private A a;
    //@Autowired
    public B(A a) {
        this.a = a;
        Set<Integer> s =new HashSet<>();
    }

}