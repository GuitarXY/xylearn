package com.example.xylearn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author xiaoy
 * @date 2021/11/19
 */
public class EnumTest {
    public static void main(String[] args) {
        NameEnum peng = NameEnum.peng;
        peng.setI(2);
        String o = JSON.toJSONString(peng);
        System.out.println(o);
        NameEnum nameEnum = JSON.parseObject(o, NameEnum.class);
        System.out.println(nameEnum.getI());
    }
}
enum NameEnum {
    xiao("xy"),
    peng("xiaoP"),
    ;
    private String value;
    private Integer i;

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getI() {
        return i;
    }

    NameEnum(String value) {
        this.value = value;
        i=1;
    }
}
