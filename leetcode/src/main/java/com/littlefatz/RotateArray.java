package com.littlefatz;

//https://leetcode-cn.com/problems/rotate-array/

public class RotateArray {

    //环形替换
    public void rotate(int[] nums, int k) {
        int count = 0;
        k = k % nums.length;
        for (int start = 0; count < nums.length; start++) {
            int currentIndex = start;
            int previousValue = nums[currentIndex];
            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int nextValue = nums[nextIndex];
                nums[nextIndex] = previousValue;
                currentIndex = nextIndex;
                previousValue = nextValue;
                count++;
            } while (currentIndex != start);
        }
    }

    //反转
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums,0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }


    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6};
        RotateArray test = new RotateArray();
        test.rotate2(data,  3);
        for (int i : data) {
            System.out.println(i);
        }
    }
}
