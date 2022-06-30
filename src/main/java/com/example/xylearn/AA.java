package com.example.xylearn;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoy
 * @date 2022/6/13
 */
@Data
@Component
@ConfigurationProperties(prefix = "tes")
public class AA {
    public static void main(String[] args) {
        String s = "${dsdsd}";
        final String substring = s.substring(1, 7);
    }
    char[] index = new char[]{'1','2','1','1','1','1','1'};
    public void a(String nu){
        char[] chars = nu.toCharArray();

    }

    private String a;
    private List<String> aa;
    private Map<String, String> maps;
}
