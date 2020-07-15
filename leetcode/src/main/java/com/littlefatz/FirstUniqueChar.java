package com.littlefatz;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    public char firstUniqChar(String s) {

        char result = ' ';

        if (s.isEmpty()) {
            return result;
        }

        Map<Character, Boolean> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, false);
            } else {
                map.put(c, true);
            }
        }

        for (char c : chars) {
            if (map.get(c)) {
                return c;
            }
        }

        return result;

    }
}
