package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author wayne
 * @version IteratorToList,  2020/4/17 7:53 下午
 */
@Slf4j
public class IteratorToList {

    @Test
    public void useWhile(){
        List<String> stringList= new ArrayList<>();
        Iterator<String> stringIterator= Arrays.asList("a","b","c").iterator();
        while(stringIterator.hasNext()){
            stringList.add(stringIterator.next());
        }
        log.info("{}",stringList);
    }

    @Test
    public void useForEachRemaining(){
        List<String> stringList= new ArrayList<>();
        Iterator<String> stringIterator= Arrays.asList("a","b","c").iterator();
        stringIterator.forEachRemaining(stringList::add);
        log.info("{}",stringList);
    }

    @Test
    public void useStream(){

        Iterator<String> stringIterator= Arrays.asList("a","b","c").iterator();
        Iterable<String> stringIterable = () -> stringIterator;
        List<String> stringList= StreamSupport.stream(stringIterable.spliterator(),false).collect(Collectors.toList());
        log.info("{}",stringList);
    }
}
