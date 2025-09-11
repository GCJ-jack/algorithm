package com.itheima.LRU;

import com.itheima.memoryerror.StaitcTest;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {


    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev,next;

        Node(){}
        Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Node<K,V> head;

    private final Node<K,V> tail;

    private final Map<K,Node<K,V>> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        if(capacity < 0){
            throw new IllegalArgumentException("capacity should not be less than zero");
        }
        this.map = new HashMap<>(capacity * 2);
        this.head = new Node<>();
        this.tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        Node<K,V> n = map.get(key);
        if(n == null){
            return null;
        }
        //move the node to the head
        return n.value;
    }

    public void put(K key, V value){
        Node<K,V> node = map.get(key);
        if(node != null){
            //move the node to the head
            return;
        }

        node = new Node<>(key,value);
        //addAfterHead
        map.put(key,node);
        addAfterHead(node);
        if(map.size() > capacity){
            // delete the tail
            Node<K,V> lru = popTail();
            map.remove(lru.key);
        }
    }

    public void addAfterHead(Node<K, V> n){
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    public void deleteNode(Node<K, V> n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = n.next = null;
    }

    private void moveToHead(Node<K,V> n){
        deleteNode(n);
        addAfterHead(n);
    }

    public Node<K,V> popTail(){
        Node<K, V> n = tail.prev;
        deleteNode(n);
        return n;
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
