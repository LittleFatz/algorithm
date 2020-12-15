package com.littlefatz.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/permutations/
public class Permutation {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return result;
        }

        boolean[] visited = new boolean[length];
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, length, visited, path);
        return result;


    }

    private void dfs(int[] nums, int length, boolean[] visited, Deque<Integer> path) {
        if (path.size() == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                path.addLast(nums[i]);
                visited[i] = true;

                dfs(nums, length, visited, path);

                visited[i] = false;
                path.removeLast();
            }
        }

    }
}
