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
        int[] lis = {1,2,6,7,9,3};
    }

}
