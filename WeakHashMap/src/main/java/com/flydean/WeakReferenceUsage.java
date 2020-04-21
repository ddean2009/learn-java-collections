package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author wayne
 * @version WeakReferenceUsage,  2020/4/20 3:25 下午
 */
@Slf4j
public class WeakReferenceUsage {

    @Test
    public void weakReference() throws InterruptedException {
        Object obj = new Object();
        WeakReference<Object> weak = new WeakReference<>(obj);
        obj = null;
        log.info("{}",weak.get());
        System.gc();
        log.info("{}",weak.get());
    }
}
