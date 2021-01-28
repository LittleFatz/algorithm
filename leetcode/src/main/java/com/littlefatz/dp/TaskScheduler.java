package com.littlefatz.dp;

import java.util.Arrays;

//https://leetcode-cn.com/problems/task-scheduler/
//题解：https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
//https://leetcode-cn.com/problems/task-scheduler/solution/tian-tong-si-lu-you-tu-kan-wan-jiu-dong-by-mei-jia/
public class TaskScheduler {

    public int leastInterval2(char[] tasks, int n) {

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
         * （这个可以从图去观察）
         * idleSlots > 0: 证明任务填不满 idleSlot，所以总时间等于 idleSlot + tasks.length
         * idleSlots <= 0: 任务种类多，idleSlot 容不下这么多 task，因此部分桶需要扩大，实际消耗时间 = tasks.length
         */
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    public int leastInterval(char[] tasks, int n) {

        int[] bucket = new int[26];
        for (char task : tasks) {
            bucket[task - 'A']++;
        }

        Arrays.sort(bucket);
        int maxTimes = bucket[25];
        int idleSlots = (maxTimes - 1) * (n + 1);

        for (int i = 24; i >= 0 && bucket[i] > 0; i--) {
            idleSlots -= Math.min(maxTimes - 1, bucket[i]);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }












}
