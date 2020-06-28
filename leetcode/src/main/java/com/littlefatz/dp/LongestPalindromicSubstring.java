package com.littlefatz.dp;


//https://leetcode-cn.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLength = 1;
        int begin = 0;

        //这里初始化对角线为true可以省略，因为后续运算中不需要依赖这个值
        boolean[][] dp = new boolean[length][length];


        char[] charArray = s.toCharArray();

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }


                if (j-i+1 > maxLength && dp[i][j]) {
                    maxLength = j - i + 1;
                    begin = i;
                }

            }
        }

        return s.substring(begin, begin + maxLength);

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("baaab"));
    }
}
