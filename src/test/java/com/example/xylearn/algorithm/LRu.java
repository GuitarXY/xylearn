package com.example.xylearn.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoy
 * @date 2022/7/11
 */
public class LRu {
    Map<Integer,LRUNode> map = new HashMap<>();
    int size;

    class LRUNode{
        int key;
        int value;
        LRUNode prev;
        LRUNode next;
    }
}
