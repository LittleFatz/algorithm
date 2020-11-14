package com.littlefatz;

//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
public class ReversePairs {
    private int[] tempNums;

    public int reversePairs(int[] nums) {
        tempNums = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int middle = left + (right - left) / 2;
        int count = mergeSort(nums, left, middle) + mergeSort(nums, middle + 1, right);
        for (int i = left, j = middle + 1; i <= middle; i++) {
            // nums[i] / 2.0 > nums[j]，为了防止溢出，所以不用乘法
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - middle - 1;
        }

        merge(nums, left, middle, right);
        return count;
    }

    private void merge(int[] nums, int left, int middle, int right) {
        for (int i = left; i <= right; i++) {
            tempNums[i] = nums[i];
        }

        int index1 = left;
        int index2 = middle + 1;
        int k = left;
        while (index1 <= middle && index2 <= right) {
            if (tempNums[index1] <= tempNums[index2]) {
                nums[k++] = tempNums[index1++];
            } else {
                nums[k++] = tempNums[index2++];
            }
        }

        while (index1 <= middle) {
            nums[k++] = tempNums[index1++];
        }

        while (index2 <= right) {
            nums[k++] = tempNums[index2++];
        }

    }

    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();
        int[] data = new int[]{7,5,6,4};
        test.reversePairs(data);
    }
}
