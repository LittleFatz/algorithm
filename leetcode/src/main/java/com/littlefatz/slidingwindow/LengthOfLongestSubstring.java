package com.littlefatz.slidingwindow;

import java.util.*;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
//https://labuladong.gitee.io/algo/2/21/58/
//https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring2(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        int length = s.length();
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int start = 0;

        for (int i = 0; i < length; i++) {
            if (map.containsKey(array[i])) {
                //如果只是start = map.get(array[i]) + 1 的话
                //那么一旦 start 被改变，然后重复的字母又在很早的位置出现
                //start 则会被重新修改到更早的位置
                /**
                 * 例如 abcdefghda 这个字符串
                 * 遍历到第二个 d 的时候，start = 3（第一个 d 的index）, start 会被更新为 4
                 * 接下来遍历到 a，如果 start = map.get(array[i]) + 1 的话，则 start = 1，最后返回的结果错误
                 *
                 * 另一个用途：假如这个重复的字符是出现在 start 之前，那么这个字符是不会影响当前这个不重复字符串的
                 */
                start = Math.max(start, map.get(array[i]) + 1);
            }
            map.put(array[i], i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring3(String s) {

        int length = s.length();
        if (length == 0) {
            return 0;
        }

        //这里使用数组来替换hashmap，能够提升运算效率，ASCII码表里的字符总共有128个。ASCII码的长度是一个字节，8位，理论上可以表示256个字符，但是许多时候只谈128个。
        int[] charIndex = new int[256];
        Arrays.fill(charIndex, Integer.MAX_VALUE);
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 1;

        for (int i = 0; i < length; i++) {
            if (charIndex[chars[i]] != Integer.MAX_VALUE) {
                left = Math.max(left, charIndex[chars[i]] + 1);
            }

            charIndex[chars[i]] = i;
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();
        int startIndex = 0;
        int max = 1;
        for (int i = 0; i < length; i++) {
            if (indexMap.containsKey(chars[i])) {
                startIndex = Math.max(startIndex, indexMap.get(chars[i]) + 1);
            }

            indexMap.put(chars[i], i);
            max = Math.max(max, i - startIndex + 1);

        }

        return max;
    }

    public int lengthOfLongestSubstring5(String s) {

        int length = s.length();
        if (length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int startIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                startIndex = Math.max(startIndex, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - startIndex + 1);
        }

        return max;
    }



    public int lengthOfLongestSubstring6(String s) {

        int length = s.length();
        if (length <= 1) {
            return length;
        }

        int max = 1;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring7(String s) {

        int length = s.length();
        if (length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }

            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;

    }

    public int lengthOfLongestSubstring8(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        int length = s.length();
        int start = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }

            map.put(chars[i], i);
            max = Math.max(max, i - start + 1);
        }

        return max;

    }


    public int lengthOfLongestSubstring9(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map  = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }


    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }

            map.put(chars[i], i);
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
















}
