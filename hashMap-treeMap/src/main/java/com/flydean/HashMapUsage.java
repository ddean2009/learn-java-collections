package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wayne
 * @version HashMapUsage,  2020/4/19 8:50 上午
 */
@Slf4j
public class HashMapUsage {

    @Test
    public void withOrder(){
        Map<String, String> books = new HashMap<>();
        books.put("bob", "books");
        books.put("c", "concurrent");
        books.put("a", "a lock");
        log.info("{}",books);
    }

    @Test
    public void withNull() {
        Map<String, String> hashmap = new HashMap<>();
        hashmap.put(null, null);
        log.info("{}",hashmap);
    }
}
