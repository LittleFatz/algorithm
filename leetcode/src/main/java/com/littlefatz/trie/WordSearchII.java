package com.littlefatz.trie;

import java.util.*;

//https://leetcode-cn.com/problems/word-search-ii/
public class WordSearchII {

    private Trie trie = new Trie();
    private boolean[][] visited;
    private int[] x = new int[]{0, 1 , 0 , -1};
    private int[] y = new int[]{1, 0 , -1, 0};
    private int n = 0;
    private int m = 0;
    private Set<String> results = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {


        for (String word : words) {
            trie.insert(word);
        }

        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                backtrack(board, "", i, j);
            }
        }

        return new ArrayList<>(results);
    }

    private void backtrack(char[][] board, String combine, int xPos, int yPos) {

        if (xPos < 0 || xPos >= n || yPos < 0 || yPos >= m || visited[xPos][yPos]) {
            return;
        }

        combine += board[xPos][yPos];
        visited[xPos][yPos] = true;

        TrieNode node = trie.searchPrefix(combine);
        if (node == null) {
            visited[xPos][yPos] = false;
            return;
        }

        if (node.isEnd()) {
            results.add(combine);
        }

        for (int k = 0; k < 4; k++) {
            backtrack(board, combine, xPos + x[k], yPos + y[k]);
        }

        visited[xPos][yPos] = false;

    }

    public static void main(String[] args) {
        WordSearchII test = new WordSearchII();
        char[][] board = new char[][]{{'a', 'a'}};
        String[] data = new String[]{"a"};
        List<String> result = test.findWords(board, data);


    }




    class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }

            int length = word.length();
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < length; i++) {
                if (!node.containsKey(chars[i])) {
                    node.put(chars[i], new TrieNode());
                }
                node = node.get(chars[i]);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null ;
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

    }

    class TrieNode {

        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
}
