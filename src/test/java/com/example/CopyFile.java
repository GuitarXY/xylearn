package com.example;

import com.example.xylearn.common.ListNode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;

/**
 * @author xiaoy
 * @date 2022/1/12
 */

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
   class NestedInteger {
       private int value;
       private List<NestedInteger> list = new ArrayList<>();
      // Constructor initializes an empty nested list.
    public NestedInteger(){}

      // Constructor initializes a single integer.
      public NestedInteger(int value){
        this.value = value;
      }

      // @return true if this NestedInteger holds a single integer, rather than a nested list.

      // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value){
        this.value = value;
      }

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni){
        list.add(ni);
      }
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
  }

public class CopyFile {
    int end = -1;
    public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0){
            return new NestedInteger();
        }
        char[] arr = s.toCharArray();
        if(arr[0] != '['){
            NestedInteger r = new NestedInteger();
            r.setInteger(Integer.parseInt(s));
            return r;
        }
        String value = "";
        NestedInteger res = new NestedInteger();
        for(int i = 0; i < arr.length;){
            if('[' == arr[i]){
                NestedInteger n = digui(++i,arr);
                res.add(n);
                if(end!=-1){
                    i=end+1;
                }
                if (i==arr.length){
                    break;
                }
                continue;
            }
            if(']'==arr[i]){
                res.setInteger(Integer.parseInt(value));
                end = i;
                break;
            }
            if(',' == arr[i]){
                i++;
                continue;
            }
            value = value+arr[i++];

        }
        return  res;
    }
    public NestedInteger digui(int index,char[] arr){
        String value = "";
        NestedInteger res = new NestedInteger();
        for(int i = index; i < arr.length;){
            if('[' == arr[i]){
                NestedInteger n = digui(++i,arr);
                res.add(n);
                if(end!=-1){
                    i=end+1;
                }
                if (i==arr.length){
                    break;
                }
                continue;
            }
            if(']'==arr[i]){
                res.setInteger(Integer.parseInt(value));
                end = i;
                break;
            }
            if(',' == arr[i]){
                i++;
                continue;
            }
            value = value+arr[i++];

        }

        return res;

    }
    public static Integer c;
    public void t1(){
       List<String> a = new ArrayList<>();
       a.stream().filter(e -> e.equals("11")).collect(Collectors.toList());
       System.out.println("1111111111");
       a.forEach(i -> i.length());
    }
    public int t(){
        int a = 1;
        int b = 1;
        int c = 1;
        return a+b;
    }

    public static void main(String[] args) throws Exception {
        String str = "{\n" +
                "    \"datas\": [{\n" +
                "        \"flowId\": 1477939063873024,\n" +
                "        \"nodeId\": \"1477952271523328\",\n" +
                "        \"uniqueId\": \"1477939063880960\",\n" +
                "        \"typeCode\": \"eventNameFieldCode\",\n" +
                "        \"typeName\": \"参数传递\",\n" +
                "        \"eventNameFieldDetails\": [{\n" +
                "            \"eventName\": \"订阅事件1\",\n" +
                "            \"eventId\": 123,\n" +
                "            \"paramList\": [{\n" +
                "                    \"fieldName\": \"字段1\",\n" +
                "                    \"fieldCode\": \"code1\",\n" +
                "                    \"typeName\": \"字符串类型\",\n" +
                "                    \"flowFieldCode\": \"流程字段code1\",\n" +
                "                    \"flowFieldName\": \"流程字段name1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"fieldName\": \"字段2\",\n" +
                "                    \"fieldCode\": \"code2\",\n" +
                "                    \"typeName\": \"字符串类型\",\n" +
                "                    \"flowFieldCode\": \"流程字段code2\",\n" +
                "                    \"flowFieldName\": \"流程字段name2\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }]\n" +
                "    },\n" +
                "    {\n" +
                "         \"flowId\": 1477939063873024,\n" +
                "        \"nodeId\": \"1477952271523328\",\n" +
                "        \"uniqueId\": \"1477939063880960\",\n" +
                "        \"typeCode\": \"subscriptionEventOpenValue\",\n" +
                "        \"typeName\": \"事件订阅开关\",\n" +
                "       \"valueDetail\":[{\"detailTypeCode\":\"subscriptionEventOpenValue\",\"detailValue\":1}] \n"+
                "    }]\n" +
                "}";
        System.out.println(str);
//        CopyFile cp = new CopyFile();
//        Arrays.asList();
//        NestedInteger deserialize = cp.deserialize("[123,[456,[789]]]");
//        cp.deserialize("[123,[456,[789]]]");
//        ListNode listNode = new ListNode("1");
//        ListNode all = listNode.setNextAndGet("2").setNextAndGet("3").setNextAndGet("4").
//                setNextAndGet("5").setNextAndGet("6").setNextAndGet("7");
//        ListNode tumy = new ListNode(0);
//        tumy.next = listNode;
//
//
//
//        ListNode pre = tumy;
//        ListNode cur = listNode;
//        ListNode next = listNode.next;
//        for(int i =0 ; i <2;i++){
//            int k = 3;//
//            for(int j = 0 ; j < k-1; j++){
//                ListNode temp  = next.next;
//                next.next = cur;
//
//                cur = next;
//                next = temp;
//            }
//            ListNode temp1 = pre.next;
//            pre.next = cur;
//            temp1.next = next;
//
//            cur = next;
//            next = next.next;
//            pre = temp1;
//
//
//        }
//
//        while(tumy.next!= null){
//            tumy = tumy.next;
//            System.out.print(tumy.getValue()+" ");
//        }

    }
}
