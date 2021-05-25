package com.caleb.alorithm.leetcode;

/**
 * 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 思路：动态规划
 *
 * @author：hanzhigang
 * @Date : 2021/4/21 9:02 PM
 */
public class CanCompleteCircuit134 {
    /**
     * 首先根据
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i = 0;  // 数组下标
        int n = cost.length;
        while (i < n) {
            int count = 0;
            int cnt = 0;
            while (cnt < n) {
                // 在某一位置寻找能够跑完一圈的加油站，如果跑完一圈，则返回当前i。
                // 如果不能跑完，则在i到j之间不论哪一个加油站都跑不到j的下一个加油站，更新i为j+1
                int j = (i + cnt) % n;
                count += gas[j] - cost[j];
                if (count < 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i += cnt + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        CanCompleteCircuit134 canCompleteCircuit134 = new CanCompleteCircuit134();
        System.out.println(canCompleteCircuit134.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
    }
}
