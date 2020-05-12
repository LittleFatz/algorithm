package com.littlefatz;

import java.math.BigInteger;

//https://leetcode-cn.com/problems/add-strings
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder builder = new StringBuilder("");
        int carry = 0;

        while (index1 >= 0 || index2 >= 0) {
            int number1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int number2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int total = number1 + number2 + carry;
            carry = total / 10;

            builder.append(total % 10);
            index1--;
            index2--;
        }
        if (carry == 1) {
            builder.append(1);
        }

        return builder.reverse().toString();
    }


    public static void main(String[] args) {

        int i = '0';
        System.out.println(i);
        int j = '9';
        System.out.println(j-i);

        int top = (int) (Math.random() * 10);

        System.out.println(top);




    }
}
