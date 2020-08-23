package com.littlefatz.bfs;

import java.util.*;

//https://leetcode-cn.com/problems/sliding-puzzle/
public class SlidingPuzzle {



    public int slidingPuzzle(int[][] board) {


        Map<Integer, List<Integer>> move = new HashMap<>();
        move.put(0, new ArrayList<Integer>(Arrays.asList(1, 3)));
        move.put(1, new ArrayList<Integer>(Arrays.asList(0, 2, 4)));
        move.put(2, new ArrayList<Integer>(Arrays.asList(1, 5)));
        move.put(3, new ArrayList<Integer>(Arrays.asList(0, 4)));
        move.put(4, new ArrayList<Integer>(Arrays.asList(1, 3, 5)));
        move.put(5, new ArrayList<Integer>(Arrays.asList(2, 4)));

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String initialString = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                initialString += board[i][j];
            }
        }
        if (initialString.equals("123450")) {
            return 0;

        }
        queue.add(initialString);
        int step = 0;
        visited.add(initialString);

        while (!queue.isEmpty()) {

            Queue<String> nextQueue = new LinkedList<>();
            for (String next : queue) {
                int zeroIndex = next.indexOf('0');
                List<Integer> moveOptions = move.get(zeroIndex);

                for (Integer option : moveOptions) {
                    char[] nextChars = next.toCharArray();

                    char temp = nextChars[option];
                    nextChars[option] = nextChars[zeroIndex];
                    nextChars[zeroIndex] = temp;

                    String newString = new String(nextChars);
                    if (newString.equals("123450")) {
                        return step + 1;
                    }

                    if (!visited.contains(newString)) {
                        nextQueue.add(newString);
                        visited.add(newString);
                    }
                }
            }

            step++;
            queue = nextQueue;

        }

        return -1;
    }

    public static void main(String[] args) {
        SlidingPuzzle test = new SlidingPuzzle();
        int[][] data = new int[][]{{4,1,2},{5,0,3}};
        System.out.println(test.slidingPuzzle(data));
    }


}
