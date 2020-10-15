package com.littlefatz.slidingwindow;

import java.util.*;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
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
                 * 遍历到第二个 d 的时候，start = 3（第一个 d 的index）
                 * 接下来遍历到 a，如果 start = map.get(array[i]) + 1 的话，则 start = 1，最后返回的结果错误
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

    public int lengthOfLongestSubstring(String s) {

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
}
