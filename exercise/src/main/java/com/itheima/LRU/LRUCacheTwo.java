package com.itheima.LRU;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCacheTwo<K,V> extends LinkedHashMap<K,V> {

    private final int capacity;

    public LRUCacheTwo(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "A");
        cache.put(2, "B");
        System.out.println(cache.get(1)); // A
        cache.put(3, "C");
        System.out.println(cache.get(2)); // null
        cache.put(4, "D");
        System.out.println(cache.get(1)); // null
        System.out.println(cache.get(3)); // C
        System.out.println(cache.get(4)); // D
    }
}
