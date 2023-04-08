package com.example.xylearn;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import org.apache.commons.collections4.ListUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author xiaoy
 * @date 2022/6/13
 */
@Data
@Component
@ConfigurationProperties(prefix = "tes")
public class AA {
    public static void main(String[] args) {
        Map<String,Object> m =  JSON.parseObject("{\"widget3\": {\n" +
              "            \"widget6\": \"write\",\n" +
              "            \"widget4\": {\"widget2\": \"qew\"}\n" +
              "        }",new TypeReference<Map<String,Object>>(){});
        changeMapToRead(m);
    }
    public static void changeMapToRead(Map<String, Object> diyCardMap) {
        diyCardMap.forEach((i,v) -> {
            if(v instanceof Map){
                Map<String, Object> stringObjectMap = JSON.parseObject(JSON.toJSONString(v), new TypeReference<Map<String, Object>>() {
                });
                changeMapToRead(stringObjectMap);
                diyCardMap.put(i,stringObjectMap);
            }else {
                diyCardMap.put(i,"read");
            }
        });
    }
    private Set<String> CutOnePoint(Set<String> changeWidgetMid) {
        Set<String> res = new HashSet<>();
        for (String s : changeWidgetMid) {
            String s1 = s.replaceFirst(".*\\.", "");
            res.add(s1);
        }
        return res;
    }
    char[] index = new char[]{'1','2','1','1','1','1','1'};
    public void a(String nu){
        char[] chars = nu.toCharArray();

    }

    private String a;
    private List<String> aa;
    private Map<String, String> maps;
}
