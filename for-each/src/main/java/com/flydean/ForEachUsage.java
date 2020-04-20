package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 * @version ForEachUsage,  2020/4/19 5:50 下午
 */
@Slf4j
public class ForEachUsage {

    @Test
    public void withForEach(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.forEach(System.out::print);
        list.stream().forEach(System.out::print);
        list.parallelStream().forEach(System.out::print);
    }
}
