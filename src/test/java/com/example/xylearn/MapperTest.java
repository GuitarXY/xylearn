package com.example.xylearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;
@SpringBootTest
public class MapperTest {
    @Autowired
    private Mapper mapper;
    @Test
    public void get() {
        mapper.get();

    }
}
