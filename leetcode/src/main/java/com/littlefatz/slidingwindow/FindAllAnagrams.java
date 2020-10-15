package com.littlefatz.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

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
}
