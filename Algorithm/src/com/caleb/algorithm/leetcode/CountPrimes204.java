package com.caleb.algorithm.leetcode;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * @author：hanzhigang
 * @Date : 2021/5/13 12:18 AM
 */
public class CountPrimes204 {

    /**
     * 根据埃氏筛法的结论，要得到自然数 N 以内的全部素数，必须把不大于" 二次根号 N "的所有素数的倍数剔除，剩下的就是素数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1; // 1不是质数
        double des = Math.sqrt(n);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (res[i] == 0) {
                count++;
                if((long) i * i < n){
                    for (int j = i * i; j < n; j += i) {
                        res[j] = 1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes204 countPrimes204 = new CountPrimes204();
        System.out.println(countPrimes204.countPrimes(10));
    }
}
