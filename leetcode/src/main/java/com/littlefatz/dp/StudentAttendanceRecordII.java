package com.littlefatz.dp;


//https://leetcode-cn.com/problems/student-attendance-record-ii/
public class StudentAttendanceRecordII {

    public int checkRecord(int n) {
        int mod = 1000000007;

        long[] f = new long[n <= 4 ? 5 : n + 1];
        /**
         * 当i=4的时候，f[4] = 13
         * 计算sum的时候需要乘以f[0]，所以f[0]=1
         */
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;

        for (int i = 4; i <= n; i++) {
            f[i] = ((2 * f[i - 1]) % mod + (mod - f[i - 4])) % mod;
        }

        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i-1] * f[n-i]) % mod;
        }

        return (int) (sum % mod);

    }

    public static void main(String[] args) {
        StudentAttendanceRecordII test = new StudentAttendanceRecordII();
        System.out.println(test.checkRecord(100));
    }
}
