package com.littlefatz;


import java.util.Random;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/
public class KthLargestElement {

    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        KthLargestElement test = new KthLargestElement();
        int[] data = new int[]{3,2,1,5,6,4};
        test.findKthLargest(data, 2);

    }

//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        int target = len - k;
//        int left = 0;
//        int right = len - 1;
//        while (true) {
//            int index = partition(nums, left, right);
//            if (index < target) {
//                left = index + 1;
//            } else if (index > target) {
//                right = index - 1;
//            } else {
//                return nums[index];
//            }
//        }
//    }
//
//    public int partition(int[] nums, int left, int right) {
//        int pivot = nums[left];
//        int j = left;
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                // 小于 pivot 的元素都被交换到前面
//                j++;
//                swap(nums, j, i);
//            }
//        }
//        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
//        swap(nums, j, left);
//        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
//        return j;
//    }
//
//
//    private void swap(int[] nums, int index1, int index2) {
//        int temp = nums[index1];
//        nums[index1] = nums[index2];
//        nums[index2] = temp;
//    }

//    public int findKthLargest(int[] nums, int k) {
//        int length = nums.length;
//        int target = length - k;
//        int left = 0;
//        int right = length - 1;
//
//        while (true) {
//            int index = partition(nums, left, right);
//            if (index == target) {
//                return nums[index];
//            } else if (index < target) {
//                left = index + 1;
//            } else {
//                right = index - 1;
//            }
//        }
//
//
//    }
//
//    //其实这里就是快排思想
//    private int partition(int[] nums, int left, int right) {
//        if (left < right) {
//            int randomIndex = left + 1 + random.nextInt(right - left);
//            swap(nums, left, randomIndex);
//        }
//
//        int pivot = nums[left];
//        int j = left;
//        for (int i = left+1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                j++;
//                swap(nums, i, j);
//            }
//        }
//
//        swap(nums, left, j);
//        return j;
//
//    }
//
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int pivot = partition(nums, start, end);
            if (pivot == target) {
                return nums[target];
            } else if (pivot < target) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }

    }

    private int partition(int[] nums, int start, int end) {

        int pivot = nums[start];
        int counter = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                counter++;
                swap(nums, counter, i);
            }
        }

        swap(nums, start, counter);
        return counter;

    }

}
