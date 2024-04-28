package com.resonit.hashmap.custom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapImpl<K, V> {
    public class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int initialCapacity = 1 << 4; // aka 16
    private final double loadFactor = 0.75F;
    private int size;
    private int capacity;
    private LinkedList<Node>[] buckets;

    public HashMapImpl() {
        this.size = 0;
        initializeBucket(initialCapacity);
    }

    private void initializeBucket(int initialCapacity) {
        buckets = new LinkedList[initialCapacity];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        this.capacity = initialCapacity;
    }

    private void put(K key, V value) {
        int hash = findHash(key);
        int dataIndex = getDataIndexWithinBucket(key, hash);
        // if key is Not present in HashMap
        if (dataIndex != -1) {
            Node node = buckets[hash].get(dataIndex);
            node.value = value;
        } else {
            Node temp = new Node(key, value);
            buckets[hash].add(temp);
            size++;
        }
        double lambda = size * 1.0 / buckets.length;
        if (lambda > loadFactor){
            rehash();
        }
    }

    private int findHash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    private int getDataIndexWithinBucket(K key, int hash) {
        int dataIndex = 0;
        for (Node node : buckets[hash]) {
            if (node.key.equals(key)) {
                return dataIndex;
            }
            dataIndex++;
        }
        return -1;
    }

    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        initializeBucket(capacity * 2);
        size = 0;
        for (int i = 0; i < oldBuckets.length; i++) {
            for (Node node : oldBuckets[i]) {
                put(node.key, node.value);
            }
        }
    }
    private V get(K key) {
        int hash = findHash(key);
        int dataIndex = getDataIndexWithinBucket(key, hash);
        if (dataIndex != -1) {
            Node node = buckets[hash].get(dataIndex);
            return node.value;
        } else
            return null;
    }

    private boolean containsKey(K key) {
        int hash = findHash(key);
        int dataIndex = getDataIndexWithinBucket(key, hash);
        if (dataIndex != -1)
            return true;
        else
            return false;
    }

    private V remove(K key) {
        int hash = findHash(key);
        int dataIndex = getDataIndexWithinBucket(key, hash);
        if (dataIndex != -1) {
            Node node = buckets[hash].remove(dataIndex);
            size--;
            return node.value;
        } else {
            return null;
        }
    }

    private ArrayList<K> keySet() {
        ArrayList<K> keySet = new ArrayList();
        for (int i = 0; i < buckets.length; i++) {
            for (Node node : buckets[i]) {
                keySet.add(node.key);
            }
        }
        return keySet;
    }

    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl();
        System.out.println(hashMap.size);
        System.out.println(hashMap.capacity);

        hashMap.put(1, "Piyush");
        hashMap.put(2, "Rahul");
        hashMap.put(3, "Pranav");
        hashMap.put(4, "Pranav");
        hashMap.put(5, "Pranav");
        hashMap.put(6, "Pranav");
        hashMap.put(7, "Pranav");
        hashMap.put(8, "Pranav");
        hashMap.put(9, "Pranav");
        hashMap.put(10, "Pranav");
        hashMap.put(11, "Pranav");
        hashMap.put(12, "Pranav");
        hashMap.put(13, "Pranav");
        hashMap.put(14, "Pranav");

        System.out.println(hashMap.get(2));
        System.out.println(hashMap.size);
        System.out.println(hashMap.containsKey(3));
        System.out.println(hashMap.remove(2));
        System.out.println(hashMap.containsKey(2));
        List list = hashMap.keySet();
        for (Object key : list) {
            System.out.println(key);
        }

        System.out.println(hashMap.size);
        System.out.println(hashMap.capacity);
    }


}
