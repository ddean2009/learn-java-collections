package com.flydean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wayne
 * @version AsListUsage,  2020/4/18 5:39 下午
 */
public class AsListUsage {

    @Test
    public void testAsList(){
        List<String> names = Arrays.asList("alice", "bob", "jack");
        names.add("mark");

    }

    @Test
    public void testList(){
        List<String> names = new ArrayList<>(Arrays.asList("alice", "bob", "jack"));
        names.add("mark");
    }
}
