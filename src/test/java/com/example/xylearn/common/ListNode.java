package com.example.xylearn.common;

public class ListNode {
    private  int key;
    private String value;
    public ListNode next;

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

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}