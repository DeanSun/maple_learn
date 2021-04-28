package com.spring.simple.ioc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Wheel {

    @Setter
    @Getter
    private String brand;

    @Setter
    @Getter
    private String spec;

}
