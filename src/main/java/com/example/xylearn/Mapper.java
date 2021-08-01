package com.example.xylearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
@Controller
public class Mapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void get() {
        String sql = "select * from qq_socialio.t_social_activity";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
       // jdbcTemplate.queryForList()
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap.toString());
        }
    }
}
