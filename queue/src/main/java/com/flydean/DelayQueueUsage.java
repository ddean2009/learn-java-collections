package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version DelayQueueUsage,  2020/4/22 11:07 下午
 */
@Slf4j
public class DelayQueueUsage {

    @Test
    public void useDelayedQueue() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        DelayQueue<DelayedUser> queue = new DelayQueue<>();
        int messageCount = 2;
        long delayTime = 500;
//        long delayTime = 50000;
        DelayedQueueConsumer consumer = new DelayedQueueConsumer(
                queue, messageCount);
        DelayedQueueProducer producer = new DelayedQueueProducer(
                queue, messageCount, delayTime);

        // when
        executor.submit(producer);
        executor.submit(consumer);

        // then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();

    }

}
