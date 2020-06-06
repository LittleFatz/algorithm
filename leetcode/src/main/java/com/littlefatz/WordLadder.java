package com.littlefatz;

import javafx.util.Pair;

import java.util.*;

//https://leetcode-cn.com/problems/word-ladder/description/
public class WordLadder {

    //广度优先搜索
    //先把每个单词的所有可能变化储存到一个字典，每次遍历的时候都检查一下这个字典有没有匹配项，如果有，证明能够找到变化的单词
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int length = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0 ; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            int level = pair.getValue();
            String word = pair.getKey();
            for (int i = 0 ; i < length; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(newWord);

                for (String transformation : allComboDict.getOrDefault(newWord, new ArrayList<>())) {

                    if (transformation.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.contains(transformation)) {
                        visited.add(transformation);
                        queue.offer(new Pair<>(transformation, level + 1));
                    }
                }

            }

        }

        return 0;


    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        List<String> words = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int length = test.ladderLength("hit", "cog", words);
        System.out.println(length);
    }




}
