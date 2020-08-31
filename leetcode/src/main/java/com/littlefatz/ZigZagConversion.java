package com.littlefatz;


import java.util.Arrays;

//https://leetcode-cn.com/problems/zigzag-conversion/
public class ZigZagConversion {


    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        String[] result = new String[numRows];
        Arrays.fill(result, "");

        int length = s.length();
        int period = 2 * numRows - 2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            int index = i % period;
            if (index < numRows) {
                result[index] += chars[i];
            } else {
                result[period - index] += chars[i];
            }
        }

        String finalResult = "";
        for (String temp : result) {
            finalResult += temp;
        }

        return finalResult;

    }
}
