package com.littlefatz.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/minimum-window-substring/
//https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/hua-dong-chuang-kou-ji-qiao-jin-jie
public class MinimumWindowSubstring {

    public String minWindow2(String s, String t) {

        if (s == null || t == null) {
            return "";
        }

        int sLength = s.length();
        int tLength = t.length();
        if (sLength == 0 || tLength == 0) {
            return "";
        }

        int left = 0;
        int right = 0;
        int distance = 0;
        int min = sLength + 1;
        int begin = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char c : tChars) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        /**
         * 框架使用滑动窗口的模板
         */
        while (right < sLength) {
            /**
             * distance表示字符串 s 和 字符串 t 之间相差多少个字符
             * 如果 s 已经包含 t 的所有字符，那么 distance = t.length
             *
             *
             *
             */
            if (tMap.containsKey(sChars[right]) && sMap.getOrDefault(sChars[right], 0) < tMap.get(sChars[right])) {
                distance++;
            }
            sMap.put(sChars[right], sMap.getOrDefault(sChars[right], 0) + 1);
            right++;

            while (distance == tLength) {
                if (right - left < min) {
                    min = right - left;
                    begin = left;
                }

                if (tMap.containsKey(sChars[left]) && (sMap.get(sChars[left]).equals(tMap.get(sChars[left])))) {
                    distance--;
                }

                sMap.put(sChars[left], sMap.get(sChars[left]) - 1);
                left++;
            }


        }

        if (min == sLength + 1) {
            return "";
        } else {
            return s.substring(begin, begin + min);
        }


    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("aa", "aa"));
    }

    public String minWindow(String s, String t) {

        int sLength = s.length();
        int tLength = t.length();

        if (sLength == 0 || tLength == 0) {
            return "";
        }

        int left = 0;
        int right = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int valid = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        char[] sChars = s.toCharArray();

        while (right < sLength) {
            char c = sChars[right];
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = sChars[left];
                left++;

                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.get(leftChar) - 1);
                }

            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);


    }

}
