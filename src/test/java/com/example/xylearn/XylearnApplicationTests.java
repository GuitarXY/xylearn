package com.example.xylearn;

import com.sun.deploy.util.ArrayUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class XylearnApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void collection() {
        int[] lis = {1,2,6,7,9,3};
        int[] a = new int[]{};
        a[0] = 2;
        List<Integer> l = new ArrayList<>();
        Integer [] objects = (Integer[])l.toArray();
        Arrays.stream(lis).boxed().collect(Collectors.toList());
    }

    @Test
    public void quickSort() {
        int[] list = {4,6,7,2,1,4};
        qiuckS(list,0,list.length-1);
        for (int i : list) {
            System.out.print(i+",");
        }
    }
    private void qiuckS(int[] a, int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] > index)
                j--;

            while (i < j && a[i] <= index)
                i++;
            if (i < j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }// 用比基准大的记录替换高位记录

        }
        a[low] =a[i];
        a[i] = index;// 将基准数值替换回 a[i]
        qiuckS(a, low, i - 1); // 对低子表进行递归排序
        qiuckS(a, i + 1, hight); // 对高子表进行递归排序
    }


    @Test
    public void merge() {
        int[] list = {4,6,7,2,1,4};
        mergeS(list,0,list.length-1);
        for (int i : list) {
            System.out.print(i+",");
        }
    }

    private void mergeS(int[] list, int start, int end) {
        int mid = (start+end)/2;
        if (start < end){

            mergeS(list,start,mid);
            mergeS(list,mid+1,end);
            mergeSort(list,start,mid,end);
        }

    }

    private void mergeSort(int[] list, int start, int mid, int end) {
        if (start >= end) {
            return;
        }
        int[] temp = new int[end - start + 1];
        int l1 = start;
        int i = 0;
        int l2 = mid+1;
        while (l1 <= mid && l2 <= end){
            if (list[l1] < list[l2]){
                temp[i++] = list[l1++];
            }else {
                temp[i++] = list[l2++];
            }
        }
        while (l1<=mid){
            temp[i++] = list[l1++];
        }
        while (l2<=end){
            temp[i++] = list[l2++];
        }
        for (int k = 0;k<temp.length;k++){
            list[start+k] = temp[k];
        }

    }

}
