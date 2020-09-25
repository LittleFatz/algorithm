package com.littlefatz;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/interval-list-intersections/
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int aLength = A.length;
        int bLength = B.length;
        if (aLength == 0) {
            return A;
        }

        if (bLength == 0) {
            return B;
        }

        List<int[]> result = new ArrayList<>();

        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < aLength && bIndex < bLength) {

            if (B[bIndex][0] <= A[aIndex][1] && B[bIndex][1] >= A[aIndex][0]) {
                int[] temp = new int[2];
                temp[0] = Math.max(A[aIndex][0], B[bIndex][0]);
                temp[1] = Math.min(A[aIndex][1], B[bIndex][1]);
                result.add(temp);
            }

            if (B[bIndex][1] > A[aIndex][1]) {
                aIndex++;
            } else {
                bIndex++;
            }
        }

        return result.toArray(new int[result.size()][2]);

    }

    public static void main(String[] args) {
        int[][] aData = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] bData = new int[][]{{1,5},{8,12},{15,24},{25,26}};

        IntervalListIntersections test = new IntervalListIntersections();
        int[][] result = test.intervalIntersection(aData, bData);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "," + result[i][1]);
        }
    }
}
