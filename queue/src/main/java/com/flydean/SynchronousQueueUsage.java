package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wayne
 * @version SynchronousQueueUsage,  2020/4/22 10:44 下午
 */
@Slf4j
public class SynchronousQueueUsage {

    @Test
    public void useCountdownLatch() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        AtomicReference<Object> atomicReference= new AtomicReference<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runnable producer = () -> {
            Object object=new Object();
            atomicReference.set(object);
            log.info("produced {}",object);
            countDownLatch.countDown();
        };

        Runnable consumer = () -> {
            try {
                countDownLatch.await();
                Object object = atomicReference.get();
                log.info("consumed {}",object);
            } catch (InterruptedException ex) {
                log.error(ex.getMessage(),ex);
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.awaitTermination(50000, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

    @Test
    public void useSynchronousQueue() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        SynchronousQueue<Object> synchronousQueue=new SynchronousQueue<>();

        Runnable producer = () -> {
            Object object=new Object();
            try {
                synchronousQueue.put(object);
            } catch (InterruptedException ex) {
                log.error(ex.getMessage(),ex);
            }
            log.info("produced {}",object);
        };

        Runnable consumer = () -> {
            try {
                Object object = synchronousQueue.take();
                log.info("consumed {}",object);
            } catch (InterruptedException ex) {
                log.error(ex.getMessage(),ex);
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.awaitTermination(50000, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }
}
