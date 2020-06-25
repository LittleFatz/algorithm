package com.littlefatz.greedy;


//https://leetcode-cn.com/problems/jump-game/
public class JumpGame {

    //从后往前遍历
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int last = length - 1;

        for (int i = length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }

        return last == 0;
    }
}
