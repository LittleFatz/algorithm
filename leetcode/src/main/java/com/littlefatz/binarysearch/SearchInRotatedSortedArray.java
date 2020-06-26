package com.littlefatz.binarysearch;

//https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //这里必须是小于等于，因为二分法收缩区域的时候，left有可能等于right
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //注意：这里必须是大于等于，因为假如数组中只有2个元素的话，left和mid就会相等，应该进入这个条件
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();

        int[] data = new int[]{4,5,6,7,0,1,2};
        System.out.println(test.search(data, 0));
    }
}
