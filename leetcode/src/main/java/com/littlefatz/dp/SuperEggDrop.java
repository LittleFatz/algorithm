package com.littlefatz.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/super-egg-drop/
//https://leetcode-cn.com/problems/super-egg-drop/solution/ji-ben-dong-tai-gui-hua-jie-fa-by-labuladong/
public class SuperEggDrop {

    private Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop2(int K, int N) {
        return dp(K, N);
    }

    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }

        if (memo.containsKey(getKey(K,N))) {
            return memo.get(getKey(K,N));
        }

        int low = 1;
        int high = N;
        int result = N;

        /**
         *
         * 在第 i 层扔下鸡蛋
         * 如果鸡蛋碎了，那么 F 值必定 1 ~ i-1,因此搜索范围缩小为 dp(K - 1, i - 1)
         * 如果不碎，那么 F 值在 i+1 ~ N，搜索范围为 dp(K, N - i)
         * dp(K - 1, i - 1) 是单调递增，dp(K, N - i) 是单调递减
         *
         */
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int broken = dp(K - 1, middle - 1);
            int notBroken = dp(K, N - middle);

            //result = min(max(碎，没碎) + 1)
            if (broken == notBroken) {
                //这里把 == 这种情况归入 > 或者 < 的 if 中都是正确的
//                low = middle + 1;
//                result = Math.min(result, notBroken + 1);
//                high = middle - 1;
//                result = Math.min(result, broken + 1);

                //直接跳出的话，速度更快
                result = Math.min(result, broken + 1);
                break;

            } else if (broken < notBroken) {
                //如果 broken < notBroken，那么证明交点在 middle 的右边，需要往右边逼近
                //因为我们要求的是 broken 和 notBroken 中的最大值，所以这里把result 更新为 notBroken + 1
                low = middle + 1;
                result = Math.min(result, notBroken + 1);
            } else if (broken > notBroken) {
                //如果 broken > notBroken，那么证明交点在 middle 的左边，需要往左边逼近
                high = middle - 1;
                result = Math.min(result, broken + 1);
            }

        }

        memo.put(getKey(K, N), result);

        return result;
    }

    private String getKey(int K, int N) {
        return K + "-" + N;
    }



    public int superEggDrop(int K, int N) {

        return dp2(K, N);
    }

    //虽然这个方法简单，但是超时
    private int dp2(int K, int N) {

        if (K == 1) {
            return N;
        }

        if (N == 0) {
            return 0;
        }

        if (memo.containsKey(getKey(K, N))) {
            return memo.get(getKey(K, N));
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            result = Math.min(result, Math.max(dp2(K - 1, i - 1), dp2(K, N - i)) + 1);
            memo.put(getKey(K, N), result);
        }

        return result;

    }


}
