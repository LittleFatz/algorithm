package com.littlefatz;


//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-arra
// 双指针
public class RemovedDuplicatesFromSortedArray {


    public int removeDuplicates(int[] nums) {

        int result = nums.length;
        if (nums.length <= 1) {
            return result;
        }
        int dup_value = nums[0];
        int dup_index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == dup_value) {
                result--;
            } else {
                nums[dup_index] = nums[i];
                dup_index++;
                dup_value = nums[i];

            }

        }

        return result;

    }

    public int removeDuplicates2(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }
        int p = 0;
        int q = 1;

        for (; q < nums.length; q++) {
            if (nums[q] != nums[p]) {
                p++;
                nums[p] = nums[q];
            }
        }

        return p + 1;

    }


    public static void main(String[] args) {
        int[] data = new int[]{1,1,2};
        RemovedDuplicatesFromSortedArray test = new RemovedDuplicatesFromSortedArray();
        int result = test.removeDuplicates2(data);
        System.out.println(result);
        for (int i : data) {
            System.out.println(i);
        }

    }
}
