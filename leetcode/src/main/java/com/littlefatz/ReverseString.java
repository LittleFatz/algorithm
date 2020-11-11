package com.littlefatz;

//https://leetcode-cn.com/problems/reverse-string/
public class ReverseString {

    public void reverseString2(char[] s) {

        int length = s.length;
        int middle = length >> 1;
        for (int i = 0; i < middle; i++) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }

    }

    public void reverseString(char[] s) {

        int middle = s.length >> 1;
        //注意 middle 位置的处理
        for (int i = 0; i <= middle; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

















}
