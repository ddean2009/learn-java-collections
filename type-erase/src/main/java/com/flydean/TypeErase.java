package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author wayne
 * @version TypeErase,  2020/4/23 8:39 下午
 */
@Slf4j
public class TypeErase {

    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("a");
        stringArrayList.add("b");
//        action(stringArrayList);
        actionTwo(stringArrayList);
    }

    public static void action(ArrayList<Object> al){
        for(Object o: al)
            log.info("{}",o);
    }

    public static void actionTwo(ArrayList<?> al){
        for(Object o: al)
            log.info("{}",o);
//           al.add("abc");
    }
}
