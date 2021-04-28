package com.spring.struct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTestIterator {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "JAVA");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        entrySet(map);
        keySet(map);
        foreachEntrySet(map);
        keySetForeach(map);
        lamdaFor(map);
        streamAPISingleton(map);
        streamAPIParallel(map);
    }

    private static void streamAPIParallel(Map<Integer, String> map) {
        System.out.println("streamAPI parallel:");
        map.entrySet().parallelStream().forEach(entry -> {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

    private static void streamAPISingleton(Map<Integer, String> map) {
        System.out.println("stramAPI singleton:");
        map.entrySet().stream().forEach((entry) -> {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

    private static void lamdaFor(Map<Integer, String> map) {
        System.out.println("lamda:");
        map.forEach((key, value)->{
            System.out.print(key);
            System.out.println(value);
        });
    }

    private static void keySetForeach(Map<Integer, String> map) {
        System.out.println("keySet foreach:");
        for(Integer key : map.keySet()){
            System.out.print(key);
            System.out.println(map.get(key));
        }
    }

    private static void foreachEntrySet(Map<Integer, String> map) {
        System.out.println("entrySet foreach:");
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static void keySet(Map<Integer, String> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        System.out.println("keySet:");
        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.print(key);
            System.out.println(map.get(key));
        }
    }

    private static void entrySet(Map<Integer, String> map) {
        //遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        System.out.println("entrySet:");
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
    }


}
