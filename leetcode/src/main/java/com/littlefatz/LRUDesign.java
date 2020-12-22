package com.littlefatz;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/lru-cache/
//https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
public class LRUDesign {

//    class LRUCache {
//
//        private int capacity;
//        private Map<Integer, Node> map;
//        private DoubleList cache;
//
//
//        public LRUCache(int capacity) {
//
//            this.capacity = capacity;
//            map = new HashMap<>();
//            cache = new DoubleList();
//
//        }
//
//        public int get(int key) {
//            if (!map.containsKey(key)) {
//                return -1;
//            }
//
//            Node node = map.get(key);
//            cache.remove(node);
//            cache.addFirst(node);
//            return node.getValue();
//        }
//
//        public void put(int key, int value) {
//
//            Node newNode = new Node(key, value);
//            if (map.containsKey(key)) {
//                Node oldNode = map.get(key);
//                cache.remove(oldNode);
//                cache.addFirst(newNode);
//                map.put(key, newNode);
//            } else {
//                if (capacity == cache.getSize()) {
//                    Node node = cache.removeLast();
//                    map.remove(node.getKey());
//                }
//
//                cache.addFirst(newNode);
//                map.put(key, newNode);
//
//            }
//
//
//        }
//    }
//
//    class DoubleList {
//
//        private Node head = new Node(0,0);
//        private Node tail = new Node(0,0);
//        private int size = 0;
//
//        public DoubleList() {
//            head.next = tail;
//            tail.prev = head;
//        }
//
//        public void addFirst(Node node) {
//
//            Node temp = head.next;
//            node.next = temp;
//            temp.prev = node;
//            head.next = node;
//            node.prev = head;
//            size++;
//        }
//
//        public void remove(Node node) {
//
//            Node prevNode = node.prev;
//            Node nextNode = node.next;
//            prevNode.next = nextNode;
//            nextNode.prev = prevNode;
//            size--;
//        }
//
//        public Node removeLast() {
//
//            Node lastNode = tail.prev;
//            Node lastPrevNode = lastNode.prev;
//            lastPrevNode.next = tail;
//            tail.prev = lastPrevNode;
//            size--;
//            return lastNode;
//        }
//
//        public int getSize() {
//            return size;
//        }
//
//    }

    class Node {

        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    class LRUCache {

        private int capacity;
        private Map<Integer, Node> map;
        private DoubleList cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                Node node = map.get(key);
                cache.remove(node);;
                cache.addFirst(node);
                return node.getValue();
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.setValue(value);
                cache.remove(node);
                cache.addFirst(node);

            } else {
                if (cache.getSize() == this.capacity) {
                    Node removeNode = cache.removeLast();
                    map.remove(removeNode.getKey());

                }
                Node newNode = new Node(key, value);
                cache.addFirst(newNode);
                map.put(key, newNode);
            }
        }
    }


    class DoubleList {
        private Node head = new Node(0,0);
        private Node tail = new Node(0,0);
        private int size = 0;

        public DoubleList() {
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node node) {
            Node nextNode = head.next;

            node.prev = head;
            head.next = node;

            nextNode.prev = node;
            node.next = nextNode;

            size++;

        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            size--;
        }

        public Node removeLast() {
            Node removeNode = tail.prev;
            Node prevNode = removeNode.prev;

            prevNode.next = tail;
            tail.prev = prevNode;
            size--;

            return removeNode;
        }

        public int getSize() {
            return this.size;
        }

    }




}
