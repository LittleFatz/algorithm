package com.littlefatz.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://leetcode-cn.com/problems/frog-jump/
public class FrogJump {

    public boolean canCross(int[] stones) {

        int length = stones.length;
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(stones[i], new HashSet<>());
        }

        map.get(0).add(0);

        for (int i = 0; i < length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        return !map.get(stones[length - 1]).isEmpty();


    }

    public static void main(String[] args) {
        FrogJump test = new FrogJump();

        int[] data = new int[]{0,1,3,5,6,8,12,17};

        System.out.println(test.canCross(data));
    }
}
