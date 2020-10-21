package com.littlefatz;

//https://leetcode-cn.com/problems/reverse-integer
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            System.out.println(pop);
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop > 8)) {
                return 0;
            }
            x = x / 10;
            result = result * 10 + pop;
        }

        return result;
    }

    public static void main(String[] args) {

        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(-19));

    }
}
