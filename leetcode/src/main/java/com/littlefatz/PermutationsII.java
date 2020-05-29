package com.littlefatz;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/permutations-ii/
//使用回溯法
//先把数字排序，画出遍历树之后，分析需要剪枝的地方
public class PermutationsII {

    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] used;
    private int length;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        used = new boolean[nums.length];
        length = nums.length;
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(0, nums, path);
        return result;
    }

    private void backtrack(int depth, int[] nums, LinkedList<Integer> path) {

        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtrack(depth + 1, nums, path);
            path.removeLast();
            used[i] = false;

        }

    }
}
