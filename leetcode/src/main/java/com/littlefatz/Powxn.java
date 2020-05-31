package com.littlefatz;

//https://leetcode-cn.com/problems/powx-n/
//快速幂，每次求n/2次幂，再根据奇偶数判断
//注意：n是int类型，需要小心取值范围
public class Powxn {

    public double myPow(double x, int n) {
        long N = n;

        if (N == 0) {
            return 1;
        }

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return getPow(x, N);
    }

    private double getPow(double x, long n) {
        if (n == 1) {
            return x;
        }

        double pow = getPow(x, n / 2);
        double result = 0;
        if (n % 2 == 1) {
            result = pow * pow * x;
        } else {
            result = pow * pow;
        }

        return result;
    }

    public static void main(String[] args) {
        Powxn test = new Powxn();
        System.out.println(test.myPow(1,-2147483648));
    }
}
