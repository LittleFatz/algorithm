package com.littlefatz.greedy;

//https://leetcode-cn.com/problems/jump-game-ii/
public class JumpGameII {

    //从前往后
    public int jump(int[] nums) {
        int steps = 0;
        int maxPostion = 0;
        int end = 0;
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {

            maxPostion = Math.max(maxPostion, i + nums[i]);
            //end代表的是每次跳跃的边界，如果扫描到的位置到达边界，那么证明这一步的跳跃范围已经遍历完毕，可以step++
            if (i == end) {
                steps++;
                end = maxPostion;//更新下一步的最大扫描范围
            }

        }

        return steps;

    }
}
