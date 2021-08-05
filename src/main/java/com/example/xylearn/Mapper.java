package com.example.xylearn;

import com.example.xylearn.procon.ProcessingThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
@Controller
public class Mapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/cpu/loop")
    public void testCPULoop() throws InterruptedException {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            new Mapper();
            num = 0;
        }

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
        String sql = "select * from qq_socialio.t_social_activity";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
       // jdbcTemplate.queryForList()
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap.toString());
        }
    }
}
