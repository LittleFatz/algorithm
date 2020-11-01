package com.littlefatz;

//https://leetcode-cn.com/problems/reverse-string/
public class ReverseString {

    public void reverseString(char[] s) {

        int length = s.length;
        int middle = length >> 1;
        for (int i = 0; i < middle; i++) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }

    }
}
