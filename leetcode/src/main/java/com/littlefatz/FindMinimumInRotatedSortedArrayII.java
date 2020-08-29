package com.littlefatz;

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                //mid 的左边一定不是最小数字,下一轮搜索区间是 [mid + 1, right]
                left = middle + 1;
            } else if (nums[middle] < nums[right]) {
                // mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                // 如果数组中只有两个元素的话，right = middle - 1 会出现数组向左越界
                right = middle;
            } else {
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

    }
}
