package com.littlefatz.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PermutationString {

    private char[] chars;
    private List<String> result = new ArrayList<>();
    private int length = 0;

    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }

        chars = s.toCharArray();
        length = s.length();
        backtrack(0);


        return result.toArray(new String[length]);


    }

    private void backtrack(int position) {
        if (position == length - 1) {
            result.add(new String(chars));
            return;
        }


        Set<Character> set = new HashSet<>();
        for (int i = position; i < length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(position, i);
            backtrack(position + 1);
            swap(position, i);
        }

    }

    private void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

}
