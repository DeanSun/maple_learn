package com.spring.jdk;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Testjdk18 {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(clock.instant());

        LocalDate date = LocalDate.now();
        LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println("date:" + date);
        System.out.println("dateFromClock:" + dateFromClock);

        LocalTime time = LocalTime.now();
        LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println("time:" + time);
        System.out.println("timeFromClock:" + timeFromClock);

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime dateTimeFromClock = LocalDateTime.now(clock);
        System.out.println("dateTime:" + dateTime);
        System.out.println("dateTimeFromClock:" + dateTimeFromClock);
    }
}
