package com.littlefatz;

//https://leetcode-cn.com/problems/container-with-most-water
//左右夹逼
public class ContaineWithMostWater {


//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0, j = height.length -1; i != j; ) {
//            int minBar = height[i] < height[j] ? height[i++] : height[j--];
//            int tempArea = minBar * (j - i + 1);
//            maxArea = Math.max(tempArea, maxArea);
//        }
//
//        return maxArea;
//    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        ContaineWithMostWater test = new ContaineWithMostWater();
        System.out.println(test.maxArea(a));

    }

//    public int maxArea(int[] height) {
//
//        int right = height.length - 1;
//        int left = 0;
//        int result = 0;
//
//        while (left < right) {
//            int area = (right - left) * Math.min(height[left], height[right]);
//            result = Math.max(result, area);
//            if (height[left] < height[right]) {
//                left++;
//            } else {
//                right--;
//
//            }
//
//        }
//
//        return result;
//    }

    public int maxArea(int[] height) {

        int result = 0;
        int left = 0 ;
        int right = height.length - 1;

        while (left < right) {

            int area = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(area, result);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }















}

