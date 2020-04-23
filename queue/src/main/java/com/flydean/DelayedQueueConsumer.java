package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version Consumer,  2020/4/22 5:43 下午
 */
@Slf4j
@Data
@AllArgsConstructor
public class DelayedQueueConsumer implements Runnable {

    private DelayQueue<DelayedUser> delayQueue;

    private int messageCount;

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            try {
                DelayedUser element = delayQueue.take();
                log.info("take {}",element );
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
    }
}