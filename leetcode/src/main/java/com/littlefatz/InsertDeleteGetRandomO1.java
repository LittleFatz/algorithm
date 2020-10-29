package com.littlefatz;

import java.util.*;

//https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
public class InsertDeleteGetRandomO1 {

    class RandomizedSet {

        private List<Integer> list;
        private Map<Integer, Integer> map;
        private Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list = new ArrayList<>();
            map  = new HashMap<>();
        }


        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            list.add(val);
            map.put(val, list.size() - 1);

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int lastVal = list.get(list.size() - 1);
            int valIndex = map.get(val);

            list.set(valIndex, lastVal);
            map.put(lastVal, valIndex);

            map.remove(val);
            list.remove(list.size() - 1);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
