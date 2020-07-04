package com.littlefatz.dp;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/triangle/
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int length = triangle.size();
        List<Integer> totalPath = new ArrayList<>(triangle.get(length - 1));

        for (int i =  length - 2; i >= 0; i--) {
            int size = triangle.get(i).size();
            List<Integer> newTotalPath = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int currentNum = triangle.get(i).get(j);
                int total = Math.min(currentNum + totalPath.get(j), currentNum + totalPath.get(j + 1));
                newTotalPath.add(total);
            }
            totalPath = newTotalPath;
        }

        return totalPath.get(0);
    }

    //优秀题解
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        //因为初始化triangle最后一行的minlen的时候，i+1大于行数，所以这个minlen初始化大小为row+1
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

}
