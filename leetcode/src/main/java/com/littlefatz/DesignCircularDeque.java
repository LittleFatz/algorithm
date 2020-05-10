package com.littlefatz;

//https://leetcode-cn.com/problems/design-circular-deque/solution/
//双指针 数组capacity+1

public class DesignCircularDeque {

    private int front = 0;
    private int rear = 0;
    private int[] deque;
    private int capacity = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        this.capacity = k + 1;
        deque = new int[k + 1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[rear] = value;
        rear = (rear + 1) % capacity;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear - 1 + capacity) % capacity;
        return deque[index];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        DesignCircularDeque deque = new DesignCircularDeque(3);
        deque.insertLast(3);
        deque.insertLast(1);
        deque.insertFront(2);

    }
}
