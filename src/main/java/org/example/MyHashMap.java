package org.example;

import java.util.LinkedList;

class MyHashMap<K, V> {
    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] buckets;
    private int size;
    private int capacity;
    private final float loadFactor;

    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity, float loadFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.buckets = new LinkedList[initialCapacity];
        this.size = 0;
    }

    public MyHashMap() {
        this(16, 0.75f);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        if (size >= capacity * loadFactor) {
            resize();
        }

        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        buckets[index].add(new Node<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return null;
        }

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return false;
        }

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    private void resize() {
        capacity *= 2;
        @SuppressWarnings("unchecked")
        LinkedList<Node<K, V>>[] newBuckets = new LinkedList[capacity];

        for (LinkedList<Node<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    int newIndex = hash(node.key);
                    if (newBuckets[newIndex] == null) {
                        newBuckets[newIndex] = new LinkedList<>();
                    }
                    newBuckets[newIndex].add(node);
                }
            }
        }

        buckets = newBuckets;
    }

    public int size() {
        return size;
    }
}





//public class Main {
//    public static void main(String[] args) {
//        MyHashMap<String, Integer> map = new MyHashMap<>();
//        map.put("One", 1);
//        map.put("Two", 2);
//        map.put("Three", 3);
//
//        System.out.println("Value for key 'Two': " + map.get("Two")); // Output: Value for key 'Two': 2
//        System.out.println("HashMap contains key 'Three': " + map.containsKey("Three")); // Output: HashMap contains key 'Three': true
//
//        for (int i = 4; i <= 20; i++) {
//            map.put("Key" + i, i);
//        }
//
//        System.out.println("Size of MyHashMap: " + map.size()); // Output: Size of MyHashMap: 20
//    }
//}
