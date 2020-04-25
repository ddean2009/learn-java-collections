package com.flydean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wayne
 * @version GenericsUsage,  2020/4/24 11:12 上午
 */
public class GenericsUsage {

    public void useGenerics(){
        List<Integer> integerList = new ArrayList<>();
//        List<Number> numberList = integerList; // compile error
//        numberList.add(new Float(1.111));

        List<?>[] list1 = new List<?>[10];
//        List<String>[] list2 = new List<String>[10]; //compile error
    }
}
