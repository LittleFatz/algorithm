package com.littlefatz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode-cn.com/problems/top-k-frequent-elements/
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() == k) {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }

        return result;

    }
}
