package com.example;

import com.example.xylearn.common.ListNode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoy
 * @date 2022/1/12
 */
public class CopyFile {
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
        ListNode listNode = new ListNode("1");
        ListNode all = listNode.setNextAndGet("2").setNextAndGet("3").setNextAndGet("4").
                setNextAndGet("5").setNextAndGet("6").setNextAndGet("7");
        ListNode tumy = new ListNode(0);
        tumy.next = listNode;



        ListNode pre = tumy;
        ListNode cur = listNode;
        ListNode next = listNode.next;
        for(int i =0 ; i <2;i++){
            int k = 3;//
            for(int j = 0 ; j < k-1; j++){
                ListNode temp  = next.next;
                next.next = cur;

                cur = next;
                next = temp;
            }
            ListNode temp1 = pre.next;
            pre.next = cur;
            temp1.next = next;

            cur = next;
            next = next.next;
            pre = temp1;


        }

        while(tumy.next!= null){
            tumy = tumy.next;
            System.out.print(tumy.getValue()+" ");
        }

    }
}