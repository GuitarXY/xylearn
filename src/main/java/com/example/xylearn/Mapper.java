package com.example.xylearn;

import com.alibaba.fastjson.JSON;
import com.example.xylearn.procon.ProcessingThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Controller
public class Mapper {
    @Value("${test.aaa}")
    private String a;
//    @Value("#{${test.map}}")
    private Map<String,String> mm;
//    @Value("#{${test.map11}}")
    private Map<String,String> mm11;
    @Autowired
    private AA ss;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/cpu/loop")
    public void testCPULoop() throws InterruptedException {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        long l = System.currentTimeMillis();
        while (true) {
            long r = System.currentTimeMillis();
            if (r-l>60000){
                break;
            }
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            new Mapper();
            num = 0;
        }
        System.out.println("请求cpu死循环 结束");
    }

    @GetMapping("/cpu/loopnewobject")
    public void testCPULoopNewObject() throws InterruptedException {
        System.out.println("循环创建对象");
        Thread.currentThread().setName("loop-thread-cpu");
        while (true) {
            new Mapper();
        }

    }
    @GetMapping("/cpu/loopnewthread")
    public void testCPULoopNewThread() throws InterruptedException {
        System.out.println("循环创建线程");
        Thread.currentThread().setName("loop-thread-cpu");
        while (true) {
            new ProcessingThread().start();
        }

    }

    public void get() {
        String sql = "select * from interface_push_config";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
       // jdbcTemplate.queryForList()
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap.toString());
        }
    }



    public static void main(String[] args) {
        System.out.println(Math.pow(8,7) %33);
        Long l = 1111L;
        String s = JSON.toJSONString(l);
        List<AA> te = new ArrayList<>();
        AA a1 = new AA();
        AA a2 = new AA();
        AA a3 = new AA();
        te.add(a1);
        te.add(a2);
        te.add(a3);
        a1.setA("a");
        a1.setAa(Arrays.asList("1","2"));
        a2.setA("a");
        a2.setAa(Arrays.asList("3","4"));
        a3.setA("b");
        a3.setAa(Arrays.asList("5","6"));
        List<AA> aas = new ArrayList<>(te.stream().collect(Collectors.toMap(AA::getA, Function.identity(), (t1, t2) -> {
            List<String> aa1 = new ArrayList<>(t1.getAa());
            List<String> aa2 = new ArrayList<>(t2.getAa());
            aa1.addAll(aa2);
            t1.setAa(aa1);
            return t1;
        })).values());

        Map<String, Optional<AA>> collect = te.stream().collect(Collectors.groupingBy(AA::getA, Collectors.reducing((t1, t2) -> {
            List<String> aa1 = new ArrayList<>(t1.getAa());
            List<String> aa2 = new ArrayList<>(t2.getAa());
            aa1.addAll(aa2);
            t1.setAa(aa1);
            return t1;
        })));
        List<AA> collect1 = collect.values().stream().map(Optional::get).collect(Collectors.toList());



        te.stream().collect(Collectors.groupingBy(AA::getA, HashMap::new,Collectors.reducing( (t1, t2) -> {
            List<String> aa1 = new ArrayList<>(t1.getAa());
            List<String> aa2 = new ArrayList<>(t2.getAa());
            aa1.addAll(aa2);
            t1.setAa(aa1);
            return t1;
        })));
        System.out.println(aas);
    }
}
