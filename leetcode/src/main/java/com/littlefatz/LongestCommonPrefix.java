package com.littlefatz;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        int count = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
