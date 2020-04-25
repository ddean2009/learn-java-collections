package com.flydean;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wayne
 * @version CustUser,  2020/4/24 2:38 下午
 */
public class CustUser<T> {

    public void useT(T param){
//        T copy = new T(param);  // compile error
//        T copy = (T) param.clone();  // compile error
    }

    public void useTSet(Set<?> set){
//        Set<?> copy1 = new HashSet<?>(set);  // compile error
        Set<?> copy2 = new HashSet<>(set);
        Set<?> copy3 = new HashSet<Object>(set);
    }

    public void useArray(){
//         T[] typeArray1= new T[20];  //compile error
        T[] typeArray2=(T[]) new Object[20];
        T[] typeArray3 = (T[]) Array.newInstance(String.class, 20);
    }
}
