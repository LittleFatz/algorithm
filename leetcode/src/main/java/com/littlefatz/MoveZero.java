package com.littlefatz;

/*
https://leetcode-cn.com/problems/move-zeroes/

双指针

[0,1,0,3,12]
 */


public class MoveZero {
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1};
        MoveZero test = new MoveZero();
        test.moveZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void moveZeroes(int[] nums) {

        int length = nums.length;
        if (length == 0) {
             return;
        }

        int slow = 0;
        int fast = 0;
        while (fast < length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        for (int k = slow; k < length; k++) {
            nums[k] = 0;
        }

    }
}
