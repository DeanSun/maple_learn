package com.spring.simple.ioc;

import com.spring.simple.ioc.entity.Bike;
import com.spring.simple.ioc.entity.Wheel;
import org.junit.jupiter.api.Test;

public class TestSimpleIOC {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC simpleIOC = new SimpleIOC(location);
        Wheel wheel = (Wheel) simpleIOC.getBean("wheel");
        System.out.println(wheel);
        Bike bike = (Bike) simpleIOC.getBean("bike");
        System.out.println(bike);
    }
}
