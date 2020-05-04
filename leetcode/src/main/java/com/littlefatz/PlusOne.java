package com.littlefatz;


//https://leetcode-cn.com/problems/plus-one/
// 注意需要考虑到进位的问题



public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        for (;index >= 0; index--) {
            int result = digits[index] + 1;
            digits[index] = result % 10;
            if (result % 10 != 0) {
                return digits;
            }

        }
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    public static void main (String[] args) {
        int[] data = new int[]{1,2,4,9};
        PlusOne test = new PlusOne();
        test.plusOne(data);
        for (int i : data) {
            System.out.println(i);
        }
    }

}
