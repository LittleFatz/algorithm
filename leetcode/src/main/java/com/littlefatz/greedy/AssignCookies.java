package com.littlefatz.greedy;

import java.util.Arrays;

//https://leetcode-cn.com/problems/assign-cookies/description/
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        int count = 0;

        Arrays.sort(g);
        Arrays.sort(s);
        boolean[] ate = new boolean[s.length];

        for (int i = 0; i < g.length; i++) {

            int eat = g[i];

            for (int j = 0; j < s.length; j++) {
                if (ate[j]) {
                    continue;
                } else {
                    int cookieSize = s[j];
                    if (cookieSize >= eat) {
                        ate[j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }


    //非官方答案
    public int findContentChildren2(int[] grid, int[] size) {
        if (grid == null || size == null) return 0;
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }


    public static void main(String[] args) {
        int[] child = new int[]{1,2,3};
        int[] cookies = new int[]{1,1};

        AssignCookies test = new AssignCookies();
        System.out.println(test.findContentChildren(child, cookies));;
    }

}
