package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
class Producer implements Runnable {
    private TransferQueue<String> transferQueue;

    private String name;

    private Integer messageCount;

    public static final AtomicInteger messageProduced = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            try {
                boolean added = transferQueue.tryTransfer( "第"+i+"个", 2000, TimeUnit.MILLISECONDS);
                log.info("transfered {} 是否成功: {}","第"+i+"个",added);
                if(added){
                    messageProduced.incrementAndGet();
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            }
        }
        log.info("total transfered {}",messageProduced.get());
    }
}

