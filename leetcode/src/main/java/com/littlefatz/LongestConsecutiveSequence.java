package com.littlefatz;

import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int result = 0;
        for (int num : nums) {
            int tempNum = num;
            int tempResult = 0;
            if (!numSet.contains(num - 1)) {
                while (numSet.contains(tempNum)) {
                    tempResult++;
                    tempNum++;
                }
                result = Math.max(result, tempResult);
            }
        }

        return result;

    }
}
