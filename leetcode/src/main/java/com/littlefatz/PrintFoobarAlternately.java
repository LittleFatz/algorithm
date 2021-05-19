package com.littlefatz;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//https://leetcode-cn.com/problems/print-foobar-alternately/
public class PrintFoobarAlternately {


    public static void main(String[] args) throws InterruptedException {
        FooBar test = new FooBar(2);
        Thread foo = new Thread() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Thread bar = new Thread() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    test.foo(foo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    test.bar(bar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}

class FooBar {
    private int n;

    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private volatile boolean flag = true;


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (!flag) {
                    fooCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                barCondition.signal();

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (flag) {
                    barCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                fooCondition.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }
    }
}
