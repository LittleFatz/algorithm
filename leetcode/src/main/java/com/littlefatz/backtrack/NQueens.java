package com.littlefatz.backtrack;

import java.util.*;

//https://leetcode-cn.com/problems/n-queens/
//使用回溯法，注意判断皇后斜线的攻击范围
public class NQueens {

    private LinkedList<Integer> position = new LinkedList<>();
    private ArrayList<ArrayList<Integer>> resutls = new ArrayList<>();
    private Set<Integer> pie = new HashSet<>();
    private Set<Integer> na = new HashSet<>();
    private Set<Integer> shu = new HashSet<>();

//    public List<List<String>> solveNQueens(int n) {
//        if (n < 1) {
//            return transformResult(n);
//        }
//
//        int row = 0;
//        search(row, n);
//        return transformResult(n);
//    }
//
//    private void search(int row, int n) {
//        if (row >= n) {
//            resutls.add(new ArrayList<>(position));
//            return;
//        }
//
//        for (int col = 0; col < n; col++) {
//            if (cols.contains(col) || na.contains(row - col) || pie.contains(row + col)) {
//                continue;
//            }
//
//            cols.add(col);
//            na.add(row - col);
//            pie.add(row + col);
//            position.add(col);
//
//            search(row + 1, n);
//
//            cols.remove(col);
//            na.remove(row - col);
//            pie.remove(row + col);
//            position.removeLast();
//        }
//
//    }

    private List<List<String>> transformResult(int n) {
        List<List<String>> answer = new ArrayList<>();

        for (ArrayList<Integer> result : resutls) {
            List<String> solution = new ArrayList<>();

            for (int pos : result) {
                String line = "";
                for (int i = 0; i < n; i++) {
                    if (i == pos) {
                        line += "Q";
                    } else {
                        line += ".";
                    }

                }
                solution.add(line);
            }

            answer.add(solution);

        }

        return answer;
    }


    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return transformResult(n);
        }
        backtrack(0, n);

        return transformResult(n);
    }

    private void backtrack(int row, int n) {

        if (row >= n) {
            resutls.add(new ArrayList<>(position));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (shu.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }

            pie.add(row + col);
            na.add(row - col);
            shu.add(col);
            position.add(col);

            backtrack(row + 1, n);

            pie.remove(row + col);
            na.remove(row - col);
            shu.remove(col);
            position.removeLast();
        }
    }


}
