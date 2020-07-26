package com.littlefatz.dp;

import java.util.Arrays;

//https://leetcode-cn.com/problems/task-scheduler/
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }

        Arrays.sort(map);
        int maxCount = map[25] - 1;
        int idleSlots = maxCount * n;

        for (int i = 24; i >= 0 && map[i] > 0; i--) {

            /**
             * 如果出现最多次数的task不止一个，例如有 A 和 B， 那么idleSlot只会减去maxCount（map[25] - 1）
             * 最后一次不占用idleSlot
             * 所以idleSlots最大能够减去maxCount
             */
            idleSlots -= Math.min(map[i], maxCount);
        }

        /**
         * idleSlots + tasks.length:
         */
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
