package com.littlefatz;


//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-arra
// 双指针
public class RemovedDuplicatesFromSortedArray {


    public int removeDuplicates3(int[] nums) {

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
        int result = test.removeDuplicates(data);
        System.out.println(result);
//        for (int i : data) {
//            System.out.println(i);
//        }
        System.out.println(data.toString());

    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        int slow = 0;
        int fast = 0;
        while (fast < length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow+1;
    }
}
