package com.littlefatz;

import javafx.util.Pair;

import java.util.*;

//https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/
public class MinimumGeneticMutation {

    //解题方法可以参考WordLadder
    public int minMutation(String start, String end, String[] bank) {

        char[] options = new char[]{'A', 'C', 'G', 'T'};
        int length = start.length();
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));
        while(!queue.isEmpty()) {
            Pair<String, Integer> gene = queue.poll();
            int count = gene.getValue();

            char[] geneArray = gene.getKey().toCharArray();
            for (int i = 0; i < length; i++) {
                char originChar = geneArray[i];
                for (int j = 0; j < 4; j++) {
                    if (options[j] == originChar) {
                        continue;
                    }

                    geneArray[i] = options[j];
                    String newString = new String(geneArray);
                    if (bankSet.contains(newString)) {
                        if (newString.equals(end)){
                            return count + 1;
                        }

                        if(!visited.contains(newString)) {
                            visited.add(newString);
                            queue.offer(new Pair(newString, count + 1));
                        }
                    }
                }
                geneArray[i] = originChar;
            }
        }


        return -1;

    }

}
