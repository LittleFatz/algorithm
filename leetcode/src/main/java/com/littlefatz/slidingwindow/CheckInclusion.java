package com.littlefatz.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/permutation-in-string/
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (char c : chars1) {
            int existCount = need.getOrDefault(c, 0);
            need.put(c, existCount + 1);
        }

        int left = 0;
        int valid = 0;
//        int right = 0;
        int length = chars2.length;
        for (int i = 0; i < length; i++) {
            char c = chars2[i];
            if (need.containsKey(c)) {
                int existCount = window.getOrDefault(c, 0);
                window.put(c, existCount + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (i - left + 1 >= s1.length()) {
                /**
                 * 这里不能使用valid == s1.length()
                 * 例如 s1 = ‘aab’， 那么这时候 s1.length() = 3， need.size() = 2
                 */
                if (valid == need.size()) {
                    return true;
                }

                char tempC = chars2[left];
                left++;
                if (need.containsKey(tempC)) {
                    if (need.get(tempC).equals(window.get(tempC))) {
                        valid--;
                    }
                    int existCount = window.get(tempC);
                    window.put(tempC, existCount - 1);
                }

            }
        }

        return false;

    }
}
