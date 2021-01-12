package com.littlefatz;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/lfu-cache/


public class LFUCache {

    public int capacity;
    public int minFrequency;

    //记录 cache 中的节点
    public Map<Integer, Node> nodeMap = new HashMap<>();

    // key 为 frequency，doublelist 记录相同frequency的节点
    public Map<Integer, DoubleList> frequencyMap = new HashMap<>();


    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFrequency = 1;
        frequencyMap.put(minFrequency, new DoubleList());
    }

    public int get(int key) {

        if (capacity == 0) {
            return -1;
        }

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            DoubleList list = frequencyMap.get(node.frequency);
            list.removeNode(node);

            int newFrequency = node.frequency + 1;

            if (!frequencyMap.containsKey(newFrequency)) {
                DoubleList newList = new DoubleList();
                newList.addToHead(node);
                frequencyMap.put(newFrequency, newList);
            } else {
                DoubleList newList = frequencyMap.get(newFrequency);
                newList.addToHead(node);
            }
            return node.value;

        } else {
            return -1;
        }

    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            int newFrequency = node.frequency + 1;
            frequencyMap.get(node.frequency).removeNode(node);
            if (!frequencyMap.containsKey(newFrequency)) {
                DoubleList newList = new DoubleList();
                newList.addToHead(node);
                frequencyMap.put(newFrequency, newList);
            } else {
                DoubleList list = frequencyMap.get(newFrequency);
                list.addToHead(node);
            }
        } else {
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            frequencyMap.get(1).addToHead(newNode);
        }
    }


    class Node {

        public int key;
        public int value;
        public Node prev;
        public Node next;
        public int frequency;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    class DoubleList {
        public Node head;
        public Node tail;
        public int length;

        public DoubleList() {
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);
            
            head.next = tail;
            tail.prev = head;
            this.length = 0;
        }

        public void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            length++;
        }

        public void addToTail(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = node;
            length++;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            length--;
        }

    }
}
