package com.littlefatz;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
//回溯法，string的拼接可以使用StringBuilder
public class LetterCombinationsOfPhone {

    private Map<Character, String> phone = new HashMap<>();
//    private List<String> resutls = new ArrayList<>();
//    private int length = 0;

    private void initializePhone() {
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

    }
//
//    public List<String> letterCombinations(String digits) {
//
//        if (digits.length() == 0) {
//            return resutls;
//        }
//
//        initializePhone();
//        length = digits.length();
//        String path = "";
//        search(digits, path, 0);
//        return resutls;
//    }
//
//    private void search(String digits, String path, int level) {
//
//        if (path.length() == length) {
//            resutls.add(new String(path));
//            return;
//        }
//
//        String options = phone.get(digits.charAt(level));
//        for (int i = 0; i < options.length(); i++) {
//            char option = options.charAt(i);
//            path += option;
//            search(digits, path, level + 1);
//            path = path.substring(0, level);
//        }
//
//    }

    public static void main(String[] args) {
        LetterCombinationsOfPhone test = new LetterCombinationsOfPhone();
        List<String> data = test.letterCombinations("23");
        System.out.println(data.toString());
    }


    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        initializePhone();
        search(result, digits, "",0);

        return result;
    }

    private void search(List<String> result, String digits, String path, int level) {
        if (level == digits.length()) {
            result.add(new String(path));
            return;
        }

        String options = phone.get(digits.charAt(level));
        for (int i = 0; i < options.length(); i++) {
            String newPath = path + options.charAt(i);
            search(result, digits, newPath, level+1);
        }
    }
}
