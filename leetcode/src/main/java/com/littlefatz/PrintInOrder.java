package com.littlefatz;

import javafx.scene.control.ContentDisplay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//https://leetcode-cn.com/problems/print-in-order/
public class PrintInOrder {
}

class Foo {

    private ReentrantLock lock = new ReentrantLock();
    private Condition firstCondition = lock.newCondition();
    private Condition secondCondition = lock.newCondition();
    private Condition thirdCondition = lock.newCondition();
    private volatile int flag = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        try {
            if (flag != 0) {
                firstCondition.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;
            secondCondition.signal();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }



    }

    public void second(Runnable printSecond) throws InterruptedException {

        lock.lock();
        try {
            if (flag != 1) {
                secondCondition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag++;
            thirdCondition.signal();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }


    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (flag != 2) {
                thirdCondition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag++;

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}