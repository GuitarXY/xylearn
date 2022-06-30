package com.example.xylearn.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author xiaoy
 * @date 2022/6/8
 */
@Component
@PropertySource("classpath:test.properties")
public class PropertyTest  {
    @Value("${jdbc.url}")
    private String url;


}
