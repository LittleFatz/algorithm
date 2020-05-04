package com.littlefatz;

//https://leetcode-cn.com/problems/merge-sorted-array/
//从后往前双指针
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int index = m + n - 1;

        while (mIndex >= 0 && nIndex >= 0) {
            if (nums1[mIndex] >= nums2[nIndex]) {
                nums1[index] = nums1[mIndex];
                mIndex--;
            } else {
                nums1[index] = nums2[nIndex];
                nIndex--;
            }
            index--;
        }

        while (mIndex >= 0) {
            nums1[index--] = nums1[mIndex--];
        }

        while (nIndex >= 0) {
            nums1[index--] = nums2[nIndex--];
        }


    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        MergeSortedArray test = new MergeSortedArray();
        test.merge(nums1, 0, nums2 ,1);

        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
