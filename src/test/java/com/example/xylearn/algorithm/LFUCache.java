package com.example.xylearn.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author xiaoy
 * @date 2022/6/8
 */
public class LFUCache {
    private int time=0;
    private int cap;
    private Map<Integer,LFUNode> map;
    private TreeSet<LFUNode> set;

    public LFUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>(map);
        set = new TreeSet<LFUNode>();
    }
    public void put(int key,int value){
        if (map.get(key) != null){
            LFUNode node = map.get(key);
            set.remove(node);

            node.time=++time;
            node.frequence = node.frequence+1;
            node.value = value;
            set.add(node);
            map.put(key,node);
        }else {
            if(map.size()==cap){
                //
                map.remove(set.first().key);
                set.remove(set.first());
            }
            LFUNode node =  new LFUNode();
            node.frequence = 1;
            node.time = time++;
            node.key = key ;
            node.value = value;
            map.put(key,node);
            set.add(node);
        }

    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        LFUNode lfuNode = map.get(key);
        set.remove(lfuNode);
        lfuNode.time=++time;
        lfuNode.frequence = lfuNode.frequence+1;
        set.add(lfuNode);
        map.put(key,lfuNode);
        return lfuNode.value;
    }

     class LFUNode implements Comparable<LFUNode>{
        int frequence ;
        int time;
        int key;
        int value;

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o instanceof LFUNode) {
                LFUNode lfuNode = (LFUNode) o;
                 return frequence == lfuNode.frequence &&
                         time == lfuNode.time;//??
             }
             return false;

         }

         @Override
         public int hashCode() {
             return Objects.hash(frequence, time, key, value);
         }

         @Override
        public int compareTo(LFUNode o) {
            return o.frequence == this.frequence?this.time-o.time:frequence - o.frequence;
        }
    }
}
