package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wayne
 * @version CompareUsage,  2020/4/21 2:14 下午
 */
@Slf4j
public class CompareUsage {

    @Test
    public void useCompare(){
        List<Integer> list1 = Arrays.asList(5, 3, 2, 4, 1);
        Collections.sort(list1);
        log.info("{}",list1);

        List<Integer> list2 = Arrays.asList(5, 3, 2, 4, 1);
        Collections.sort(list2, (a, b) -> b - a);
        log.info("{}",list2);
    }
}
