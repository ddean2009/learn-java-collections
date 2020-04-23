package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version Producer,  2020/4/22 5:35 下午
 */
@Slf4j
@Data
@AllArgsConstructor
class DelayedQueueProducer implements Runnable {
    private DelayQueue<DelayedUser> delayQueue;

    private Integer messageCount;

    private long delayedTime;

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            try {
                DelayedUser delayedUser = new DelayedUser(
                        new Random().nextInt(1000)+"", delayedTime);
                log.info("put delayedUser {}",delayedUser);
                delayQueue.put(delayedUser);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
    }
}

