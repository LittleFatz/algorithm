package com.littlefatz.sort;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;

        quickSort(nums, start, end);

        return nums;

    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {

        int pivot = nums[start];
        int counter = start;
        for (int i = start+1; i <= end; i++) {
            if (nums[i] < pivot) {
                counter++;
                swap(nums, counter, i);
            }
        }

        swap(nums, counter, start);
        return counter;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {

    }
}
