package com.flydean;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author wayne
 * @version TransferQueueUsage,  2020/4/22 5:45 下午
 */
public class TransferQueueUsage {

    @Test
    public void testOneProduceZeroConsumer() throws InterruptedException {

        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        ExecutorService exService = Executors.newFixedThreadPool(10);
        Producer producer = new Producer(transferQueue, "ProducerOne", 5);

        exService.execute(producer);

        exService.awaitTermination(50000, TimeUnit.MILLISECONDS);
        exService.shutdown();
    }

    @Test
    public void testOneProduceOneConsumer() throws InterruptedException {

        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        ExecutorService exService = Executors.newFixedThreadPool(10);
        Producer producer = new Producer(transferQueue, "ProducerOne", 2);
        Consumer consumer = new Consumer(transferQueue, "ConsumerOne", 2);

        exService.execute(producer);
        exService.execute(consumer);

        exService.awaitTermination(50000, TimeUnit.MILLISECONDS);
        exService.shutdown();
    }

    @Test
    public void testManyProduceManyConsumer() throws InterruptedException {

        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        ExecutorService exService = Executors.newFixedThreadPool(10);
        Producer producer1 = new Producer(transferQueue, "ProducerOne", 5);
        Consumer consumer1 = new Consumer(transferQueue, "ConsumerOne", 5);
        Producer producer2 = new Producer(transferQueue, "ProducerTwo", 3);
        Consumer consumer2 = new Consumer(transferQueue, "ConsumerTwo", 3);

        exService.execute(producer1);
        exService.execute(consumer1);
        exService.execute(producer2);
        exService.execute(consumer2);

        exService.awaitTermination(50000, TimeUnit.MILLISECONDS);
        exService.shutdown();
    }
}
