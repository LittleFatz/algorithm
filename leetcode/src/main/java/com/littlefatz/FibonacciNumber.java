package com.littlefatz;

//https://leetcode-cn.com/problems/fibonacci-number/
public class FibonacciNumber {

    //解题方法和爬楼梯一样，只使用两个临时变量，保存前两个变量的value即可
    public int fib(int N) {

        if (N <= 1) {
            return N;
        }

        int f0 = 0;
        int f1 = 1;
        int result = 0;

        for (int i = 2; i <= N; i++) {
            result = f0 + f1;
            f0 = f1;
            f1 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        FibonacciNumber test = new FibonacciNumber();
        System.out.println(test.fib(2));

    }
}
