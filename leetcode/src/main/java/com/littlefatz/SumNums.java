package com.littlefatz;

//https://leetcode-cn.com/problems/qiu-12n-lcof/
public class SumNums {

    public int sumNums(int n) {
        if (n < 1) {
            return 0;
        }

        return n + sumNums(n-1);
    }

    public static void main(String[] args) {
        SumNums test = new SumNums();
        System.out.println(test.sumNums(5));;
    }
}
