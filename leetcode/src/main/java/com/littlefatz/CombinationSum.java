package com.littlefatz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/combination-sum/
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    //https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/583297/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int length = candidates.length;
        if (length == 0) {
            return result;
        }

        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, 0, target, path);


        return result;
    }

    private void dfs(int[] candidates, int begin, int target, LinkedList<Integer> path) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
        }

        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.removeLast();
        }

    }
}
