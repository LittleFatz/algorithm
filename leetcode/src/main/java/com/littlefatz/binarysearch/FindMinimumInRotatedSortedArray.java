package com.littlefatz.binarysearch;


//https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1) {
            return nums[left];
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = 0;

        while (right > left) {
            //这种方式计算mid，是为了防止数组越界
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();

        int[] data = new int[]{2,1};
        System.out.println(test.findMin(data));;
    }


}
