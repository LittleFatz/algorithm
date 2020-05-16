package com.littlefatz;


import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/valid-anagram/description/
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            } else {
                count.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (count.containsKey(t.charAt(i))) {
                count.put(t.charAt(i), count.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        for (int value : count.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;

    }

    //参考题解
    //为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。
    // 因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        ValidAnagram test = new ValidAnagram();
        boolean flag = test.isAnagram("aacc", "ccac");
        System.out.println(flag);
    }
}
