package com.littlefatz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/combinations/
//回溯法
public class Combinations {

    int n = 0;
    int k = 0;
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(1, list);
        return results;
    }

    private void backTrack(int first, LinkedList<Integer> current) {
        if (current.size() == k) {
            results.add(new LinkedList<>(current));
        }

        for (int i = first; i < n + 1; i++) {
            current.add(i);
            backTrack(i + 1, current);
            current.removeLast();
        }


    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        List<List<Integer>> results = test.combine(4,2);
        for (List<Integer> result : results) {
            System.out.println(result.toString());
        }

        System.out.println(results.toString());
    }
}
