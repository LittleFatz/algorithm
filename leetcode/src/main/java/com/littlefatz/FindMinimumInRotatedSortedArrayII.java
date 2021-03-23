package com.littlefatz;

//https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
// 题解：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
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

    public int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        /**
         * left 和 right 比较的时候使用 <= 和 < 都可以
         */
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else if (numbers[middle] < numbers[right]) {
                right = middle;
            } else {
                right--;
            }
        }

        return numbers[left];
    }




}
