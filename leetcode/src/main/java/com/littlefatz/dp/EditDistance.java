package com.littlefatz.dp;

//https://leetcode-cn.com/problems/edit-distance/
public class EditDistance {

//    public int minDistance(String word1, String word2) {
//
//        if (word1.equals(word2)) {
//            return 0;
//        }
//
//        int length1 = word1.length();
//        int length2 = word2.length();
//
//        if (length1 == 0) {
//            return length2;
//        }
//
//        if (length2 == 0) {
//            return length1;
//        }
//
//
//        char[] word1Chars = word1.toCharArray();
//        char[] word2Chars = word2.toCharArray();
//
//         int[][] dp = new int[length1+1][length2+1];
//
//         for (int i = 0; i <= length1; i++) {
//             dp[i][0] = i;
//         }
//
//         for (int j = 0; j <= length2; j++) {
//             dp[0][j] = j;
//         }
//
//        /**
//         * 状态转移
//         * 31. 增，dp[i][j] = dp[i][j - 1] + 1
//         * 32. 删，dp[i][j] = dp[i - 1][j] + 1
//         * 33. 改，dp[i][j] = dp[i - 1][j - 1] + 1
//         *
//         */
//        for (int i = 0; i < length1; i++) {
//             for (int j = 0; j < length2; j++) {
//                 if (word1Chars[i] == word2Chars[j]) {
//                     dp[i+1][j+1] = dp[i][j];
//                 } else {
//                     dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j]) + 1;
//                 }
//             }
//         }
//
//         return dp[length1][length2];
//
//    }

    //官方答案
    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0)
            return n + m;

        // DP 数组
        int [][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return D[n][m];
    }


    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        System.out.println(test.minDistance("distance", "springbok"));

    }


    public int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0) {
            return length2;
        }

        if (length2 == 0) {
            return length1;

        }

        int[][] dp = new int[length1+1][length2+1];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {

                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    min = Math.min(min, dp[i][j-1]);
                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[length1][length2];

    }
}
