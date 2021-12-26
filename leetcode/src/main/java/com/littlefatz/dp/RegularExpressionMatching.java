package com.littlefatz.dp;

//https://leetcode-cn.com/problems/regular-expression-matching
//https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/


public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];
        dp[0][0] = true;

        for (int j = 1; j <= cp.length; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j-2];//题目中说如果出现了*，那么*前一定有个字符，所以这里不会数组越界
            }
        }

        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') {
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] //例如 aab 和 aabb* 匹配，这个结果为true，b*重复0次，等于抹去p的最后两个字符
                                || dp[i - 1][j]; // 例如 aabb 和 aab* 匹配，b 重复了两次，结果是和 aab和aab*的匹配结果一致，意思是看看p中的b*能够和多少个s中的b匹配
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[cs.length][cp.length];
    }
}
