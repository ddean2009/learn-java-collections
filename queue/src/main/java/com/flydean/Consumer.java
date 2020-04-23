package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wayne
 * @version Consumer,  2020/4/22 5:43 下午
 */
@Slf4j
@Data
@AllArgsConstructor
public class Consumer implements Runnable {

    private TransferQueue<String> transferQueue;

    private String name;

    private int messageCount;

    public static final AtomicInteger messageConsumed = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            try {
                String element = transferQueue.take();
                log.info("take {}",element );
                messageConsumed.incrementAndGet();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
        log.info("total consumed {}",messageConsumed.get());
    }

}