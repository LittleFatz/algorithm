package com.littlefatz.sort;

public class QuickSort {

//    public int[] sortArray(int[] nums) {
//        int length = nums.length;
//        int start = 0;
//        int end = length - 1;
//
//        quickSort(nums, start, end);
//
//        return nums;
//
//    }
//
//    private void quickSort(int[] nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        int pivot = partition(nums, start, end);
//        quickSort(nums, start, pivot - 1);
//        quickSort(nums, pivot + 1, end);
//    }
//
//    private int partition(int[] nums, int start, int end) {
//
//        int pivot = nums[start];
//        int counter = start;
//        for (int i = start+1; i <= end; i++) {
//            if (nums[i] < pivot) {
//                counter++;
//                swap(nums, counter, i);
//            }
//        }
//
//        swap(nums, counter, start);
//        return counter;
//    }
//
//    private void swap(int[] nums, int index1, int index2) {
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
//    }

    public static void main(String[] args) {

    }

//    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void quickSort(int[] nums, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//
//        int pivot = partition(nums, left, right);
//        quickSort(nums, left, pivot - 1);
//        quickSort(nums, pivot + 1, right);
//
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        int counter = left;
//        int pivot = nums[left];
//        for (int k = left + 1; k <= right; k++) {
//            if (nums[k] < pivot) {
//                counter++;
//                swap(nums, counter, k);
//            }
//        }
//
//        swap(nums, counter, left);
//        return counter;
//    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
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
        for (int i = start + 1; i <= end; i++) {
            //nums[i] < pivot 才会推进counter的移动
            if (nums[i] < pivot) {
                //这里需要先 counter++， 因为counter初始值是start，第一次是先交换 counter+1 的位置
                counter++;
                swap(nums, i, counter);
            }
        }
        //最后才把 pivot 和 counter 位置互换
        swap(nums, counter, start);
        return counter;
    }
}
