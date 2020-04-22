package com.flydean;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wayne
 * @version FIFOEntry,  2020/4/22 3:05 下午
 */
public class FIFOEntry<E extends Comparable<? super E>>
        implements Comparable<FIFOEntry<E>> {
    static final AtomicLong seq = new AtomicLong(0);
    final long seqNum;
    final E entry;
    public FIFOEntry(E entry) {
        seqNum = seq.getAndIncrement();
        this.entry = entry;
    }
    public E getEntry() { return entry; }
    public int compareTo(FIFOEntry<E> other) {
        int res = entry.compareTo(other.entry);
        if (res == 0 && other.entry != this.entry)
            res = (seqNum < other.seqNum ? -1 : 1);
        return res;
    }
}