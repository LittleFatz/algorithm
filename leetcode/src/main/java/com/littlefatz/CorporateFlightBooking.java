package com.littlefatz;

//https://leetcode-cn.com/problems/corporate-flight-bookings/solution/
public class CorporateFlightBooking {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        Difference difference = new Difference(n);

        int length = bookings.length;
        for (int i = 0;i < length; i++) {
            int from = bookings[i][0] - 1;
            int to = bookings[i][1] - 1;
            int value = bookings[i][2];

            difference.add(from, to, value);
        }

        return difference.getResult();

    }

    class Difference {

        private int[] diff;

        public Difference(int n) {
            diff = new int[n];
        }

        public void add(int i, int j, int value) {
            diff[i] += value;
            if (j + 1 < diff.length) {
                diff[j+1] -= value;
            }
        }

        public int[] getResult() {
            int length = diff.length;
            int[] result = new int[length];
            result[0] = diff[0];

            for (int i = 1; i < length; i++) {
                result[i] = result[i-1] + diff[i];
            }

            return result;
        }
    }
}
