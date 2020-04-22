package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author wayne
 * @version PriorityQueueUsage,  2020/4/22 2:54 下午
 */
@Slf4j
public class PriorityQueueUsage {

    @Test
    public void usePriorityQueue(){
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();

        integerQueue.add(1);
        integerQueue.add(3);
        integerQueue.add(2);

        int first = integerQueue.poll();
        int second = integerQueue.poll();
        int third = integerQueue.poll();

        log.info("{},{},{}",first,second,third);
    }

    @Test
    public void usePriorityQueueWithComparator(){
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>((a,b)-> b-a);
        integerQueue.add(1);
        integerQueue.add(3);
        integerQueue.add(2);

        int first = integerQueue.poll();
        int second = integerQueue.poll();
        int third = integerQueue.poll();

        log.info("{},{},{}",first,second,third);
    }
}
