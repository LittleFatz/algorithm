package com.littlefatz;

public class LongestCommonPrefix {

    public String longestCommonPrefix2(String[] strs) {

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

    public String longestCommonPrefix3(String[] strs) {

        int count = strs.length;
        if (count == 0) {
            return "";
        }

        int length = strs[0].length();
        char[] chars = strs[0].toCharArray();

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != chars[i]) {
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0];
    }



    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }

        String firstString = strs[0];
        int firstLength = firstString.length();
        int maxLength = 0;
        for (int i = 0; i < firstLength; i++) {
            for (int j = 1; j < length; j++) {
                if (i == strs[j].length() || firstString.charAt(i) != strs[j].charAt(i)) {
                    return firstString.substring(0, i);
                }
            }
        }

        return firstString;
    }






}
