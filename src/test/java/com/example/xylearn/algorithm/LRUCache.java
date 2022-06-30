package com.example.xylearn.algorithm;

import org.junit.platform.commons.util.LruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoy
 * @date 2022/6/8
 */
public class LRUCache {
    private Map<Integer,LRUNode> map ;
    LRUNode pre;
    LRUNode end;
    int size;
    public LRUCache(int size) {
        this.size = size;
        map = new HashMap<>(size);
        pre = new LRUNode();
        end = new LRUNode();
        pre.next = end;
        end.pre = pre;
    }
    public int get(int key){
        if(map.get(key) != null){

            LRUNode lruNode = map.get(key);
            if(pre.next.key == key){
                return lruNode.value;
            }
            LRUNode tem = pre.next;
            LRUNode p = lruNode.pre;
            LRUNode ln = lruNode.next;
            p.next = ln;
            ln.pre = p;
            pre.next = lruNode;
            lruNode.pre = pre;
            lruNode.next = tem;
            tem.pre = lruNode;

            return lruNode.value;
        }
        return -1;
    }
    public void put(int key,int value){
        if(map.get(key) != null){

            LRUNode lruNode = map.get(key);
            lruNode.value = value;
            LRUNode tem = pre.next;
            LRUNode p = lruNode.pre;
            LRUNode ln = lruNode.next;
            p.next = ln;
            ln.pre = p;
            pre.next = lruNode;
            lruNode.pre = pre;
            lruNode.next = tem;
            tem.pre = lruNode;

        }else {
            LRUNode lruNode = new LRUNode();
            lruNode.key = key;
            lruNode.value = value;
            if (size == map.size()){
                //删除再添加
                LRUNode pre = end.pre;
                map.remove(pre.key);
                LRUNode pre1 = pre.pre;
                pre1.next = pre.next;
                pre.next.pre = pre1;
            }
            map.put(key,lruNode);
            LRUNode next = pre.next;
            next.pre = lruNode;
            lruNode.next = next;
            pre.next = lruNode;
            lruNode.pre = pre;

        }
    }

    private class LRUNode {
        int key;
        int value;
        LRUNode pre;
        LRUNode next;

    }

    public static void main(String[] args) {
        System.out.println(Map.class.getTypeName());
        LRUCache l = new LRUCache(1);
        l.put(2,1);
        l.get(2);
        l.put(3,3);
        l.get(2);
        l.get(3);
    }
}
