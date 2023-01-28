package com.littlefatz;


import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/two-sum/
//哈希表

public class TwoSum {
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < nums.length; i++) {
//
//            int complement = target - nums[i];
//            if (index.containsKey(complement)) {
//                return new int[]{index.get(complement), i};
//            }
//            index.put(nums[i], i);
//
//        }
//        return new int[]{};
//    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }

            map.put(num, i);
        }

        return new int[]{};
    }


















}
