package com.littlefatz;


import java.util.Arrays;

//https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
public class MinNumber {

    public String minNumber(int[] nums) {

        int length = nums.length;
        String[] values = new String[length];
        for (int i = 0; i < length; i++) {
            values[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(values, (x, y) -> {
            return (x + y).compareTo(y + x);
        });

        StringBuilder builder = new StringBuilder();
        for (String s : values) {
            builder.append(s);
        }

        return builder.toString();

    }
}
