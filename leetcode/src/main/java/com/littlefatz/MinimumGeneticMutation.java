package com.littlefatz;

import javafx.util.Pair;

import java.util.*;

//https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/
public class MinimumGeneticMutation {

    //解题方法可以参考WordLadder
//    public int minMutation(String start, String end, String[] bank) {
//
//        char[] options = new char[]{'A', 'C', 'G', 'T'};
//        int length = start.length();
//        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
//        Set<String> visited = new HashSet<>();
//
//        Queue<Pair<String, Integer>> queue = new LinkedList<>();
//        queue.offer(new Pair(start, 0));
//        while(!queue.isEmpty()) {
//            Pair<String, Integer> gene = queue.poll();
//            int count = gene.getValue();
//
//            char[] geneArray = gene.getKey().toCharArray();
//            for (int i = 0; i < length; i++) {
//                char originChar = geneArray[i];
//                for (int j = 0; j < 4; j++) {
//                    if (options[j] == originChar) {
//                        continue;
//                    }
//
//                    geneArray[i] = options[j];
//                    String newString = new String(geneArray);
//                    if (bankSet.contains(newString)) {
//                        if (newString.equals(end)){
//                            return count + 1;
//                        }
//
//                        if(!visited.contains(newString)) {
//                            visited.add(newString);
//                            queue.offer(new Pair(newString, count + 1));
//                        }
//                    }
//                }
//                geneArray[i] = originChar;
//            }
//        }
//
//
//        return -1;
//
//    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(end) || bank.length == 0) {
            return -1;
        }


        char[] options = new char[]{'A', 'C', 'G', 'T'};
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int geneLength = start.length();

        startSet.add(start);
        endSet.add(end);
        int step = 0;

        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String gene : startSet) {
                char[] geneChars = gene.toCharArray();
                for (int i = 0; i< geneLength; i++) {
                    char oldChar = geneChars[i];
                    for (char option : options) {
                        if (option == oldChar) {
                            continue;
                        }

                        geneChars[i] = option;
                        String newGene = new String(geneChars);
                        if (endSet.contains(newGene)) {
                            return step + 1;
                        }

                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            visited.add(newGene);
                            nextLevel.add(newGene);
                        }

                    }
                    geneChars[i] = oldChar;
                }
            }

            startSet = nextLevel;
            step++;
        }

        return -1;

    }


















}
