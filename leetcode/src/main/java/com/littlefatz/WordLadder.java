package com.littlefatz;

import javafx.util.Pair;

import java.util.*;

//https://leetcode-cn.com/problems/word-ladder/description/
public class WordLadder {

    //广度优先搜索
    //先把每个单词的所有可能变化储存到一个字典，每次遍历的时候都检查一下这个字典有没有匹配项，如果有，证明能够找到变化的单词
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {

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

    //参考答案
    //双向广度优先遍历
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // 标准写法，总的 visited 数组
        Set<String> visited = new HashSet<>();

        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int len = beginWord.length();
        int step = 1;
        // 简化成 while (!beginVisited.isEmpty()) 亦可
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 打开以方便调试
             System.out.println("beginVisited => " + beginVisited);
             System.out.println("  endVisited => " + endVisited + "\n");

            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 逻辑到这里，保证 beginVisited 是相对较小的集合
            // nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char currentChar = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (charArray[i] == c) {
                            continue;
                        }
                        charArray[i] = c;
                        String nextWord = String.valueOf(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (endVisited.contains(nextWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                nextLevelVisited.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    // 恢复，下次再用
                    charArray[i] = currentChar;
                }
            }

            // 这一行代表表示从 begin 这一侧向外扩散了一层
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (dict.size() == 0 || !dict.contains(endWord)) {
            return 0;
        }

        Set<String> beginVisited = new HashSet<>();
        Set<String> endVisited = new HashSet<>();

        //避免多层次遍历后，新搜索的单词其实在更早的层次就已经被遍历过
        Set<String> visited = new HashSet<>();


        int step = 1;
        beginVisited.add(beginWord);
        endVisited.add(endWord);
        int wordLength = beginWord.length();

        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {

            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisit = new HashSet<>();
            for (String word : beginVisited) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordLength; i++) {
                    char oldChar = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldChar) {
                            continue;
                        }
                        wordChars[i] = c;
                        String newWord = new String(wordChars);

                        if (dict.contains(newWord)) {
                            if (endVisited.contains(newWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(newWord)) {
                                visited.add(newWord);
                                nextLevelVisit.add(newWord);
                            }
                        }


                    }
                    wordChars[i] = oldChar;


                }
            }
            beginVisited = nextLevelVisit;
            step++;

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
