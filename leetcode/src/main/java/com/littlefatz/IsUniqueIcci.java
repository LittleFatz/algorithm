package com.littlefatz;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/problems/is-unique-lcci/
public class IsUniqueIcci {


    public boolean isUnique(String astr) {
        Set<Character> dict = new HashSet<>();
        char[] array = astr.toCharArray();

        for (char c : array) {
            if (dict.contains(c)) {
                return false;
            } else {
                dict.add(c);
            }
        }

        return true;
    }

}
