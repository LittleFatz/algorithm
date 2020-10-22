package com.littlefatz;

//https://leetcode-cn.com/problems/palindrome-number/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int result = 0;
        int number = x;
        while (number > 0) {
            int pop = number % 10;
            result = result * 10 + pop;
            number = number / 10;
        }

        return result == x;


    }
}
