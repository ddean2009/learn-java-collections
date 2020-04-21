package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * @author wayne
 * @version SoftReferenceUsage,  2020/4/20 3:22 下午
 */
@Slf4j
public class SoftReferenceUsage {

    @Test
    public void softReference(){
        Object obj = new Object();
        SoftReference<Object> soft = new SoftReference<>(obj);
        obj = null;
        log.info("{}",soft.get());
        System.gc();
        log.info("{}",soft.get());
    }
}
