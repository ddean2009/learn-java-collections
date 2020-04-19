package com.flydean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wayne
 * @version CustLinkedHashMap,  2020/4/19 2:32 下午
 */
public class CustLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = 10;

    public CustLinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
