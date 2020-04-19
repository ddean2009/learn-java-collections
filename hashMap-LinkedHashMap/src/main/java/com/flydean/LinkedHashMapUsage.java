package com.flydean;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author wayne
 * @version LinkedHashMapUsage,  2020/4/19 2:00 下午
 */
public class LinkedHashMapUsage {

    @Test
    public void insertOrder(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ddd","desk");
        map.put("aaa","ask");
        map.put("ccc","check");
        map.keySet().forEach(System.out::println);
    }

    @Test
    public void accessOrder(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, .75f, true);
        map.put("ddd","desk");
        map.put("aaa","ask");
        map.put("ccc","check");
        map.keySet().forEach(System.out::println);
        map.get("aaa");
        map.keySet().forEach(System.out::println);
    }

    @Test
    public void removeEldestEntry(){

    }
}
