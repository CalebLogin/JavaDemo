package com.caleb.algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author：hanzhigang
 * @Date : 2021/5/7 11:43 PM
 */
public class LargestNumber179 {

    /**
     * 优先队列
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {

        StringBuilder stringBuilder = new StringBuilder();
        Queue<Integer> q = new PriorityQueue<>(this::judge);    // 构造一个大根堆

        for (int i : nums) {
            q.add(i);
        }
        if (q.peek() == 0) {
            return "0";
        }
        while (!q.isEmpty()) {
            stringBuilder.append(q.poll());
        }
        return stringBuilder.toString();
    }

    private int judge(int o1, int o2) {

        long s1 = 10, s2 = 10;
        while (s1 <= o1) {
            s1 *= 10;
        }
        while (s2 <= o2) {
            s2 *= 10;
        }
        return (int) (-s2 * o1 - o2 + s1 * o2 + o1);
    }

    public String largestNumber1(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        LargestNumber179 largestNumber179 = new LargestNumber179();
        System.out.println(largestNumber179.largestNumber(new int[]{999999991, 9}));
    }
}
