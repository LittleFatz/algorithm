package com.littlefatz;

//https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (Character.isSpaceChar(c)) {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace test = new ReplaceSpace();
        System.out.println(test.replaceSpace("We are happy."));
        ;
    }
}
