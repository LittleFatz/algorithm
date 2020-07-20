package com.littlefatz.dp;

import java.util.Arrays;

//https://leetcode-cn.com/problems/house-robber-ii/description/
public class HouseRobberII {

    public int rob(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));

    }

    private int myRob(int[] nums) {

        //类似上楼梯，只需要记录n-2和n-1的值即可，不需要dp数组
        int prepre = 0;
        int pre = 0;
        int tmp = 0;
        for (int num : nums) {
            tmp = pre;
            pre = Math.max(prepre + num, pre);
            prepre = tmp;
        }

        return pre;


    }
}