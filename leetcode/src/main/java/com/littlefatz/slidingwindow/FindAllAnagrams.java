package com.littlefatz.slidingwindow;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
public class FindAllAnagrams {

    public List<Integer> findAnagrams2(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return result;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int k = 0; k < p.length(); k++) {
            sCount[s.charAt(k) - 'a']++;
            pCount[p.charAt(k) - 'a']++;
        }
        int start = 0;
        for (int k = p.length(); k < s.length(); k++) {
            if (isAnagram(sCount, pCount)) {
                result.add(start);
            }

            sCount[s.charAt(start) - 'a']--;
            start++;
            sCount[s.charAt(k) - 'a']++;
        }

        if (isAnagram(sCount, pCount)) {
            result.add(start);
        }

        return result;

    }

    private boolean isAnagram(int[] sCount, int[] pCount) {
        for (int k = 0; k < 26; k++) {
            if (sCount[k] != pCount[k]) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();

        if (sLength == 0 || pLength == 0 || sLength < pLength) {
            return result;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        int startIndex = 0;
        for (int i = p.length(); i < sLength; i++) {
            if (isAnagram(sCount, pCount)) {
                result.add(startIndex);
            }

            sCount[s.charAt(startIndex) - 'a']--;
            startIndex++;
            sCount[s.charAt(i) - 'a']++;
        }

        /**
         * 因为判断 isAnagram 之前，i 已经提前移动到下一个字符，所以需要 for loop 结束后，单独做多一次 isAnagram
         */
        if (isAnagram(sCount, pCount)) {
            result.add(startIndex);
        }

        return result;

    }
}
