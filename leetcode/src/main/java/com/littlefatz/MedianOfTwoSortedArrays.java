package com.littlefatz;

//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        int totalLength = length1 + length2;
        int index1 = 0;
        int index2 = 0;


        int median = totalLength % 2 == 1 ? totalLength / 2 + 1 : totalLength / 2;
        int middle = median / 2;
        int targetIndex = 0;
        boolean isFirst = true;
        while (index1 < length1 && index2 < length2) {

            index1 += middle - 1;
            index2 += middle - 1;

            if (nums1[index1 + middle - 1] >= nums2[index2 + middle - 1]) {
                index2 += middle;
                targetIndex = index1 + middle - 1;
                isFirst = true;
            } else {
                index1 += middle;
                targetIndex = index2 + middle - 1;
                isFirst = false;
            }

            if (middle == 0) {
                break;
            } else {
                middle = middle / 2;
            }
        }

        if (totalLength % 2 == 1) {
            if (isFirst) {
                return nums1[targetIndex];
            } else {
                return nums2[targetIndex];
            }
        } else {
            if (isFirst) {
                return (nums1[targetIndex] + nums1[targetIndex + 1]) / 2;
            } else {
                return (nums2[targetIndex] + nums1[targetIndex + 1]) / 2;
            }
        }

    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//
//        int totalLength = length1 + length2;
//        if (totalLength % 2 == 1) {
//            return findKth(nums1, nums2, 0 ,0, totalLength / 2 + 1);
//        } else {
//            return (findKth(nums1, nums2, 0 ,0, totalLength / 2) + findKth(nums1, nums2, 0 ,0, totalLength / 2 + 1)) / 2;
//        }
//
//    }
//
//    private double findKth(int[] nums1, int[] nums2, int index1, int index2, int k) {
//
//        if (index1 >= nums1.length) {
//            return nums2[index2 + k - 1];
//        }
//        if (index2 >= nums2.length) {
//            return nums1[index1 + k - 1];
//        }
//        if (k == 1) {
//            return Math.min(nums1[index1], nums2[index2]);
//        }
//
//        /**
//         * 如果 k 的大小已经超过数组长度的话，则把这个数留到最后才删除
//         * 例如 nums1 = [1], nums2=[2,3,4,5,6,7]，这时候 k=4，而 nums1的长度为 1，无法删除 k/2 = 2个元素
//         * 这时候即使淘汰 nums2 的 2 个元素也没问题
//         * 因为我们需要找第 k 个元素，因此必然需要淘汰 k/2 个元素，然而 nums1 连 k/2 个元素都没有，所以 nums2 需要淘汰 k/2个元素
//         *
//         */
//        int middle1 = (index1 + k/2 - 1) < nums1.length ? nums1[index1 + k/2 - 1] : Integer.MAX_VALUE;
//        int middle2 = (index2 + k/2 - 1) < nums2.length ? nums2[index2 + k/2 - 1] : Integer.MAX_VALUE;
//
//        if (middle1 < middle2) {
//            return findKth(nums1, nums2, index1+k/2 ,index2, k-k/2);
//        }
//
//        return findKth(nums1, nums2, index1 ,index2+k/2, k-k/2);
//
//    }


    public static void main(String[] args) {

        int[] data1 = new int[]{1,3};
        int[] data2 = new int[]{2};
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        double result = test.findMedianSortedArrays(data1,data2);
        System.out.println(result);
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            return findKth(nums1, nums2, 0, 0, totalLength / 2 + 1);
        } else {
            return (findKth(nums1, nums2, 0,0, totalLength / 2) + findKth(nums1, nums2, 0,0, totalLength / 2 + 1)) / 2;
        }

    }

    private double findKth(int[] nums1, int[] nums2, int index1, int index2, int k) {

        /**
         * 能够进入这个 if 条件，证明 nums1 所有元素已经被排除了，中位数只可能出现在 nums2中
         */
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }

        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }


        int value1 = ((index1 + k / 2 - 1) >= nums1.length) ? Integer.MAX_VALUE : nums1[index1 + k / 2 - 1];
        int value2 = ((index2 + k / 2 - 1) >= nums2.length) ? Integer.MAX_VALUE : nums2[index2 + k / 2 - 1];

        if (value1 <= value2) {
            return findKth(nums1, nums2, index1 + k / 2, index2, k - k / 2);
        } else {
            return findKth(nums1, nums2, index1, index2 + k / 2, k - k / 2);
        }

    }



//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        int totalLength = length1 + length2;
//
//        if (totalLength % 2 == 1) {
//            return findKth(nums1, nums2, 0 ,0, totalLength / 2 + 1);
//        } else {
//            return (findKth(nums1, nums2, 0 ,0, totalLength / 2) + findKth(nums1, nums2, 0 ,0, totalLength / 2 + 1)) / 2;
//        }
//    }
//
//    private double findKth(int[] nums1, int[] nums2, int index1, int index2, int k) {
//        if (index1 >= nums1.length) {
//            return nums2[index2 + k - 1];
//        }
//
//        if (index2 >= nums2.length) {
//            return nums1[index1 + k - 1];
//        }
//
//        if (k == 1) {
//            return Math.min(nums1[index1], nums2[index2]);
//        }
//
//        int value1 = (index1 + k/2 - 1) >= nums1.length ? Integer.MAX_VALUE : nums1[index1 + k/2 - 1];
//        int value2 = (index2 + k/2 - 1) >= nums2.length ? Integer.MAX_VALUE : nums2[index2 + k/2 - 1];
//
//        if (value1 < value2) {
//            return findKth(nums1, nums2, index1 + k/2, index2, k - k/2);
//        }
//
//        return findKth(nums1, nums2, index1, index2 + k/2, k - k/2);
//
//    }

}
