package com.example.xylearn.common;

import java.util.logging.Level;

public class ListNode {
    private  int key;
    private String value;
    public ListNode next;
    public static ListNode of(String s){
        final String[] split = s.split(",");
        ListNode l = new ListNode();
        ListNode tesss = l;
        for (String s1 : split) {
            ListNode te = new ListNode(Integer.parseInt(s1));
            tesss.next = te;
            tesss = tesss.next;
        }
        return l.next;
    }
    public ListNode() {
    }

    public ListNode(String value) {
        this.value = value;
    }
    public ListNode(int key) {
        this.key = key;
    }

    public ListNode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode setNextAndGet(String value){
        this.next = new ListNode(value);
        return this.next;
    }
    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}