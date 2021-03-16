package com.littlefatz;

import java.util.Arrays;

public class GetLeastNumber {

    public int[] getLeastNumbers(int[] arr, int k) {
        int length = arr.length;
        if (length == 0 || k == 0) {
            return new int[0];
        }

        return quickSort(arr, 0, length - 1, k - 1);

    }

    private int[] quickSort(int[] nums, int start, int end, int targetIndex) {

        int partition = partition(nums, start, end);
        if (partition == targetIndex) {
            return Arrays.copyOf(nums, targetIndex + 1);
        } else if (partition > targetIndex) {
            return quickSort(nums, start, partition - 1, targetIndex);
        } else {
            return quickSort(nums, partition + 1, end, targetIndex);
        }

    }

    private int partition(int[] nums, int start, int end) {

        int pivot = nums[start];
        int counter = start;

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= pivot) {
                counter++;
                swap(nums, i, counter);
            }
        }

        swap(nums, start, counter);;
        return counter;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
