package com.littlefatz;


//https://leetcode-cn.com/problems/3sum/
//先排序，再左右夹逼


import com.sun.media.sound.RIFFReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> results = new ArrayList<List<Integer>>();
//
//        Arrays.sort(nums);
//
//        for (int k = 0; k < nums.length - 2; k++) {
//            if (k > 0 && nums[k] == nums[k-1]) {
//                continue;
//            }
//            if (nums[k] > 0) {
//                return results;
//            }
//            for (int left = k + 1, right = nums.length - 1; left < right;) {
//                int sum  = nums[k] + nums[left] + nums[right];
//                if (sum == 0) {
//                    results.add(Arrays.asList(nums[k], nums[left], nums[right]));
//                    while (left < right && nums[left] == nums[left+1]) {
//                        left++;
//                    }
//                    while (left < right && nums[right] == nums[right-1]) {
//                        right--;
//                    }
//                    left++;
//                    right--;
//
//                } else if (sum < 0) {
//                    left++;
//                } else {
//                    right--;
//                }
//
//            }
//
//        }
//        return results;
//
//    }

    public static void main(String[] args) {
//        int[] a = new int[]{-1,0,1,2,-1,-4};
        int[] a = new int[]{0,0,0};
        ThreeSum test = new ThreeSum();
        System.out.println(test.threeSum(a));


    }

    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        if (length == 0) {
             return result;
        }

        Arrays.sort(nums);


        for (int i = 0; i < length - 2; i++) {

            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }


    public List<List<Integer>> threeSum3(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {

            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 只有当 sum == 0 的时候，才需要考虑
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }

        }

        return result;

    }


    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;


                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return result;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;


                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return result;
    }
















}
