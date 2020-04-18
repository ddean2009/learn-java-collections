package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wayne
 * @version CopyList,  2020/4/18 9:20 下午
 */
@Slf4j
public class CopyList {

    @Test
    public void withConstructor(){
        List<String> stringList=new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> copyList = new ArrayList<>(stringList);
        copyList.set(0,"e");
        log.info("{}",stringList);
        log.info("{}",copyList);

        List<CustBook> objectList=new ArrayList<>(Arrays.asList(new CustBook("a"),new CustBook("b"),new CustBook("c")));
        List<CustBook> copyobjectList = new ArrayList<>(objectList);
        copyobjectList.get(0).setName("e");
        log.info("{}",objectList);
        log.info("{}",copyobjectList);
    }

    @Test
    public void withAddAll(){
        List<String> stringList=new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> copyList = new ArrayList<>();
        copyList.addAll(stringList);
        log.info("{}",copyList);

        List<CustBook> objectList=new ArrayList<>(Arrays.asList(new CustBook("a"),new CustBook("b"),new CustBook("c")));
        List<CustBook> copyobjectList = new ArrayList<>();
        copyobjectList.addAll(objectList);
        copyobjectList.get(0).setName("e");
        log.info("{}",objectList);
        log.info("{}",copyobjectList);
    }

    @Test
    public void withCopy(){
        List<String> stringList=new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> copyList = new ArrayList<>(Arrays.asList("d","e","f","g"));
        Collections.copy(copyList, stringList);
        log.info("{}",copyList);

        List<CustBook> objectList=new ArrayList<>(Arrays.asList(new CustBook("a"),new CustBook("b"),new CustBook("c")));
        List<CustBook> copyobjectList = new ArrayList<>(Arrays.asList(new CustBook("d"),new CustBook("e"),new CustBook("f")));
        Collections.copy(copyobjectList, objectList);
        copyobjectList.get(0).setName("e");
        log.info("{}",objectList);
        log.info("{}",copyobjectList);
    }

    @Test
    public void withStream(){
        List<String> stringList=new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> copyList=stringList.stream().collect(Collectors.toList());
        log.info("{}",copyList);

        List<CustBook> objectList=new ArrayList<>(Arrays.asList(new CustBook("a"),new CustBook("b"),new CustBook("c")));
        List<CustBook> copyobjectList=objectList.stream().collect(Collectors.toList());
        copyobjectList.get(0).setName("e");
        log.info("{}",objectList);
        log.info("{}",copyobjectList);

    }
}
