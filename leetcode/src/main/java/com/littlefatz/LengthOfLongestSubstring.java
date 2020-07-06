package com.littlefatz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

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
                //那么一旦left被改变，然后重复的字母又在很早的位置出现
                //left则会被重新修改到更早的位置，
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
}
