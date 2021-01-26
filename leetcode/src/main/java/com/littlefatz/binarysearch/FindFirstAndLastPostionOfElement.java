package com.littlefatz.binarysearch;

//https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//题解参考：https://mp.weixin.qq.com/s/M1KfTfNlu4OCK8i9PSAmug
public class FindFirstAndLastPostionOfElement {

    public int[] searchRange2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }

        int[] result = new int[2];
        result[0] = findLeftBound2(nums, target);
        result[1] = findRightBound2(nums, target);

        return result;
    }

    private int findLeftBound2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                right = middle - 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        /**
         * 当 target 比数组中所有元素都大的时候，left 会不断向右移动知道 left = nums.length，因此需要检查 left 是否越界
         * 当 target 比数组中所有元素都小的时候，只有 right 不断向左移动，left始终等于 0 ，因此不需要检查是否越下界
         */
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;

    }

    private int findRightBound2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        /**
         * 道理和上面一样，由于这个方法需要找到的是 rightBound，因此只需要关注 right 即可
         * right < 0: target 比所有元素都小， right = -1
         * nums[right] != target: target 比所有元素都大，left = right + 1
         */
        //
        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }

        int leftBound = findLeftBound(nums, target);
        int rightBound = findRightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }




    private int findLeftBound3(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }


    private int findRightBound3(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;

    }



    private int findRightBound(int[] nums, int target) {

        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }

    private int findLeftBound(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                right = middle - 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }

        if (left >= length || nums[left] != target) {
            return -1;
        }

        return left;
    }










}
