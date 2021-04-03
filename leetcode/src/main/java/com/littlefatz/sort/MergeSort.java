package com.littlefatz.sort;


//https://leetcode-cn.com/problems/sort-an-array/
public class MergeSort {

//    public int[] sortArray(int[] nums) {
//        mergeSort(nums, 0, nums.length - 1);
//        return nums;
//    }

//    private void mergeSort(int[] nums, int left, int right) {
//        if (left < right) {
//            int mid = (left + right) >> 1;
//            mergeSort(nums, left, mid);
//            mergeSort(nums, mid+1, right);
//
//            merge(nums, left, mid, right);
//        }
//    }
//
//    private void merge(int[] nums, int left, int mid, int right) {
//        int[] temp = new int[right - left + 1];
//        int index1 = left;
//        int index2 = mid + 1;
//        int k = 0;
//        while (index1 <= mid && index2 <= right) {
//            temp[k++] = nums[index1] <= nums[index2] ? nums[index1++] : nums[index2++];
//        }
//
//        while (index1 <= mid) {
//            temp[k++] = nums[index1++];
//        }
//
//        while (index2 <= right) {
//            temp[k++] = nums[index2++];
//        }
//
//        for (int i = 0; i < temp.length; i++) {
//            nums[left+i] = temp[i];
//        }
//
//    }

//    public int[] sortArray(int[] nums) {
//        mergeSort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void mergeSort(int[] nums, int left, int right) {
//        if (left < right) {
//            int middle = left + (right - left) / 2;
//            mergeSort(nums, left, middle);
//            mergeSort(nums, middle + 1, right);
//
//            merge(nums, left, middle, right);
//        }
//    }
//
//    private void merge(int[] nums, int left, int middle, int right) {
//        int[] temp = new int[right - left + 1];
//        int index1 = left;
//        int index2 = middle + 1;
//        int index = 0;
//
//        while (index1 <= middle && index2 <= right) {
//            if (nums[index1] <= nums[index2]) {
//                temp[index++] = nums[index1++];
//            } else {
//                temp[index++] = nums[index2++];
//            }
//        }
//
//        while (index1 <= middle) {
//            temp[index++] = nums[index1++];
//        }
//
//        while (index2 <= right) {
//            temp[index++] = nums[index2++];
//        }
//
//        index = 0;
//        for (int k = left; k <= right; k++) {
//            nums[k] = temp[index++];
//        }
//
//    }

    public static void main(String[] args) {
        int[] data = new int[]{-2,3,-5};
        MergeSort test = new MergeSort();
        test.sortArray(data);
    }

//    public int[] sortArray(int[] nums) {
//        mergeSort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void mergeSort(int[] nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//
//        int middle = start + (end - start) / 2;
//        mergeSort(nums, start, middle);
//        mergeSort(nums, middle + 1, end);
//        merge(nums, start, middle, end);
//    }
//
//    private void merge(int[] nums, int start, int middle, int end) {
//
//        int index1 = start;
//        int index2 = middle + 1;
//        int[] temp = new int[end - start + 1];
//        int index = 0;
//
//        while (index1 <= middle && index2 <= end) {
//            if (nums[index1] <= nums[index2]) {
//                temp[index++] = nums[index1++];
//            } else {
//                temp[index++] = nums[index2++];
//            }
//        }
//
//        while (index1 <= middle) {
//            temp[index++] = nums[index1++];
//        }
//
//        while (index2 <= end) {
//            temp[index++] = nums[index2++];
//        }
//
//        index = 0;
//        for (int i = start; i <= end; i++) {
//            nums[i] = temp[index++];
//        }
//    }


    public int[] sortArray(int[] nums) {

        int length = nums.length;
        if (length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {

        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);
            merge(nums, left, middle, right);
        }

    }

    private void merge(int[] nums, int left, int middle, int right) {

        int index1 = left;
        int index2 = middle + 1;
        int[] temp = new int[right - left + 1];
        int counter = 0;

        while (index1 <= middle && index2 <= right) {
            if (nums[index1] <= nums[index2]) {
                temp[counter++] = nums[index1++];
            } else {
                temp[counter++] = nums[index2++];
            }
        }

        while (index1 <= middle) {
            temp[counter++] = nums[index1++];
        }

        while (index2 <= right) {
            temp[counter++] = nums[index2++];
        }

        for (int i = left, j = 0; i <= right; i++, j++) {
            nums[i] = temp[j];
        }

    }


}
