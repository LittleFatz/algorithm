package com.littlefatz;


import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/majority-element/description/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap =  new HashMap<>();

        for (int i : nums) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }

        int count = Integer.MIN_VALUE;
        int majority = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > count) {
                majority = entry.getKey();
                count = entry.getValue();
            }
        }

        return majority;
    }

    //摩尔投票法
    public int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
                continue;
            }

            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }


        }

        return candidate;

    }

    //参考答案
    //摩尔投票法
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
