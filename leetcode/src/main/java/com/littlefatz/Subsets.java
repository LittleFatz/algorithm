package com.littlefatz;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/subsets/
public class Subsets {

    private List<List<Integer>> resutls = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length == 0) {
            return resutls;
        }

        LinkedList<Integer> path = new LinkedList<>();
        findSubSet(nums, path, 0);
        return resutls;
    }

    //每次递归一个元素的时候，这个元素都可以用或者不用
    private void findSubSet(int[] nums, LinkedList<Integer> path, int index) {

        if (index == nums.length) {
            resutls.add(new ArrayList<>(path));
            return;
        }

        findSubSet(nums, path, index + 1);

        path.add(nums[index]);
        findSubSet(nums, path, index + 1);
        path.removeLast();

    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] data = new int[]{1,2,3};
        List<List<Integer>> result = test.subsets(data);
        System.out.println(result.toString());
    }
}