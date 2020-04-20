package com.flydean;

import org.junit.Test;

import java.util.EnumMap;

/**
 * @author wayne
 * @version EnumMapUsage,  2020/4/19 7:48 下午
 */
public class EnumMapUsage {

    @Test
    public void useEnumMap(){
        EnumMap<Types, String> activityMap = new EnumMap<>(Types.class);
        activityMap.put(Types.BLACK,"black");
        activityMap.put(Types.GREEN,"green");
        activityMap.put(Types.RED,"red");
    }
}
