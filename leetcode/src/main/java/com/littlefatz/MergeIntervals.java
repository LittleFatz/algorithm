package com.littlefatz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/merge-intervals/
public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);
        for (int i = 1; i < length; i++) {
            int[] peek = result.get(result.size()-1);
            if (intervals[i][0] > peek[1]) {
                result.add(intervals[i]);
            } else {
                peek[1] = Math.max(peek[1],intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

}
