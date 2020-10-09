package com.littlefatz.sort;

public class MergeSort {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);

            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index1 = left;
        int index2 = mid + 1;
        int k = 0;
        while (index1 <= mid && index2 <= right) {
            temp[k++] = nums[index1] <= nums[index2] ? nums[index1++] : nums[index2++];
        }

        while (index1 <= mid) {
            temp[k++] = nums[index1++];
        }

        while (index2 <= right) {
            temp[k++] = nums[index2++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[left+i] = temp[i];
        }

    }
}
