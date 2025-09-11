package com.itheima.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {


    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev, next;
        Node(){};
        Node(K k, V v) { key = k; value = v; }
    }

    private final int capacity;

    private final Map<K,Node<K,V>> map;
    // 哨兵头：head.next 最新

    private final Node<K,V> head;
    // 哨兵尾：tail.prev 最久

    private final Node<K,V> tail;


    public LRUCache(int capacity) {
        if(capacity < 0){
            throw  new IllegalArgumentException("capacity should not less than zero");
        }
        this.capacity = capacity;
        this.map = new HashMap<>(capacity * 2);

        this.head = new Node<>();
        this.tail = new Node<>();

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        Node<K,V> node = map.get(key);
        if(node == null){
            return null;
        }
        return node.value;
    }

    public void put(K key, V value){
        Node<K,V> node = map.get(key);
        //check the node whether it exist
        if(node != null){
            node.value = value;
            moveToHead(node);
            return;
        }
        // create the new node to store
        Node<K,V> newNode = new Node<>(key,value);
        map.put(key,newNode);
        // put it after the head
        addAfterHead(newNode);
        if(map.size() > capacity){
            Node<K, V> lru = popTail();
            map.remove(lru.key);
        }
    }

    private void addAfterHead(Node<K,V> node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(Node<K,V> node){
        removeNode(node);
        addAfterHead(node);
    }

    private Node<K, V> popTail() {
        Node<K,V> node = tail.prev;
        removeNode(node);
        return node;
    }


    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "A"); // [1:A]
        cache.put(2, "B"); // [2:B, 1:A]
        System.out.println(cache.get(1)); // A，且 1 变最新 -> [1:A, 2:B]
        cache.put(3, "C"); // 淘汰 2 -> [3:C, 1:A]
        System.out.println(cache.get(2)); // null（被淘汰）
        cache.put(4, "D"); // 淘汰 1 -> [4:D, 3:C]
        System.out.println(cache.get(1)); // null
        System.out.println(cache.get(3)); // C
        System.out.println(cache.get(4)); // D
    }

}
