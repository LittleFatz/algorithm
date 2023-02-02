package com.littlefatz.dp;


//https://leetcode-cn.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

//    public String longestPalindrome(String s) {
//
//        int length = s.length();
//        if (length < 2) {
//            return s;
//        }
//
//        int maxLength = 1;
//        int begin = 0;
//
//        //这里初始化对角线为true可以省略，因为后续运算中不需要依赖这个值
//        boolean[][] dp = new boolean[length][length];
//
//
//        char[] charArray = s.toCharArray();
//
//        for (int j = 1; j < length; j++) {
//            for (int i = 0; i < j; i++) {
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i+1][j-1];
//                    }
//                }
//
//
//                if (j-i+1 > maxLength && dp[i][j]) {
//                    maxLength = j - i + 1;
//                    begin = i;
//                }
//
//            }
//        }
//
//        return s.substring(begin, begin + maxLength);
//
//    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("aacabdkacaa"));
    }

//    public String longestPalindrome(String s) {
//
//        int length = s.length();
//        String result = "";
//        for (int i = 0; i < length; i++) {
//            String s1 = palindrome(s, i, i);
//            String s2 = palindrome(s, i, i + 1);
//            String tempMax = s1.length() > s2.length() ? s1 : s2;
//            result = result.length() > tempMax.length() ? result : tempMax;
//        }
//
//        return result;
//    }
//
//    private String palindrome(String s, int left, int right) {
//        char[] chars = s.toCharArray();
//        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
//            left--;
//            right++;
//        }
//
//        return s.substring(left + 1, right);
//    }


    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        int maxLength = 1;
        int startIndex = 0;

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    /**
                     *    1. 如果 i 到 j 的长度小于等于 3（只有 2 或者 3 个字符），那么这时候一定是回文串
                     *    2. 否则的话，则需要参考 dp[i+1][j-1] 是不是回文串
                     */
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }

        System.out.println(startIndex);
        System.out.println(maxLength);
        return s.substring(startIndex, startIndex + maxLength);


    }


    public String longestPalindrome3(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        /**
         * 这里 maxLength 必须初始化为 1，如果初始化为 0， 那么如果 s = "ab"，结果会返回空字符串，
         * 这时候实际上需要返回 a 或者 b，因此必须初始化为 1
         */
        int maxLength = 1;
        int startIndex = 0;

        char[] chars = s.toCharArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }

            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }


    public String longestPalindrome4(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 1;
        int startIndex = 0;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }


    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        int length = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[length][length];

        for (int k = 0; k < length; k++) {
            dp[k][k] = true;
        }

        int maxLength = 1;
        int startIndex = 0;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }

            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }















}
