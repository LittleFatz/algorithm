package com.littlefatz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/permutations/
//回溯法，原理类似于深度优先遍历树，每次遍历到叶子节点后，需要回退到上一个状态
public class Permutations {

    private List<List<Integer>> results = new ArrayList<>();
//    private int size = 0;
//    private boolean[] used;

//    public List<List<Integer>> permute2(int[] nums) {
//        if (nums.length == 0) {
//            return results;
//        }
//
//        this.size = nums.length;
//        used = new boolean[size];
//        LinkedList<Integer> current = new LinkedList<>();
//        backTrack(nums, 0, current);
//        return results;
//    }
//
//
//    private void backTrack2(int[] nums, int depth, LinkedList<Integer> current) {
//
//        if (depth == size) {
//            results.add(new LinkedList<>(current));
//            return;
//        }
//
//        for (int i = 0; i < size; i++) {
//            if (used[i]) {
//                continue;
//            }
//
//            current.add(nums[i]);
//            used[i] = true;
//            backTrack(nums, depth+1, current);
//            current.removeLast();
//            used[i] = false;
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Permutations test = new Permutations();
//        List<List<Integer>> results = test.permute(new int[]{1,2,3});
//        System.out.println(results.toString());
//    }

//    private List<List<Integer>> result = new ArrayList<>();
//    private int size;
//    private boolean[] used;
//
//    public List<List<Integer>> permute(int[] nums) {
//
//        int length = nums.length;
//        if (length == 0) {
//            return result;
//        }
//
//        size = length;
//        used = new boolean[size];
//        LinkedList<Integer> current = new LinkedList<>();
//        backTrack(nums, 0, current);
//        return result;
//
//    }
//
//    private void backTrack(int[] nums, int depth, LinkedList<Integer> current) {
//
//        if (depth == size) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        for (int i = 0; i < size; i++) {
//            if (!used[i]) {
//                current.addLast(nums[i]);
//                used[i] = true;
//                backTrack(nums, depth + 1, current);
//                used[i] = false;
//                current.removeLast();
//            }
//        }
//
//    }

    private boolean[] visited;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return result;
        }

        visited = new boolean[length];

        backTrack(nums, new LinkedList<Integer>());

        return result;
    }

    private void backTrack(int[] nums, LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                backTrack(nums, current);
                current.removeLast();
                visited[i] = false;
            }
        }
    }






}
