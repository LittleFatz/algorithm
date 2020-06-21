package com.littlefatz.greedy;


import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/lemonade-change/description/
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        boolean result = true;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(5, 0);
        count.put(10, 0);

        for (int pay : bills) {
            if (pay == 5) {
                count.put(5, count.get(5) + 1);
            } else if (pay == 10) {
                count.put(10, count.get(10) + 1);
                if (count.get(5) > 0) {
                    count.put(5, count.get(5) - 1);
                } else {
                    return false;
                }

            } else {
                if (count.get(10) > 0) {
                    pay = pay - 10;
                    count.put(10, count.get(10) - 1);
                }

                for (; pay > 5; pay = pay - 5) {
                    if (count.get(5) > 0) {
                        count.put(5, count.get(5) - 1);
                    } else {
                        return false;
                    }

                }
            }
        }

        return result;
    }


    //官方答案
    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    //国际站答案
    public boolean lemonadeChange3(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] data = new int[]{5,5,5,5,10,5,10,10,10,20};
        LemonadeChange test = new LemonadeChange();

        System.out.println(test.lemonadeChange(data));
    }
}
