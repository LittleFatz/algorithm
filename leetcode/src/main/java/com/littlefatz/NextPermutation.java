package com.littlefatz;

//https://leetcode-cn.com/problems/next-permutation/
public class NextPermutation {

    public void nextPermutation2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }

        //证明该序列是最大的序列，直接翻转
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int secondIndex = -1;
        for (int i = nums.length - 1; i >=0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }

        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
        return;

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }

    public void nextPermutation(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i +1]) {
                firstIndex = i;
                break;
            }
        }

        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int secondIndex = -1;
        for (int i = nums.length - 1; i > firstIndex; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }

        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
        return;

    }

























}
