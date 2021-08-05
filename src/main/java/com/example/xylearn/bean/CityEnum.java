package com.example.xylearn.bean;

public enum CityEnum {
    nanchang(1,"南昌");

    CityEnum(Integer id ,String name) {
        this.name = name;
        this.id= id;
    }

    private String name;
    private Integer id;
}
