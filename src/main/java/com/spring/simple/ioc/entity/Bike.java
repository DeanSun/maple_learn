package com.spring.simple.ioc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Bike {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String length;

    @Getter
    @Setter
    private String width;

    @Getter
    @Setter
    private String height;

    @Getter
    @Setter
    private Wheel wheel;


}
