package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @Date : 2021/4/9 4:40 PM
 */
public class Merge56_ {
    /**
     * 按照最后一个下标进行排序
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        List<int[]> res = new ArrayList<>();    // 返回结果
        for (int i = intervals.length - 1; i >= 0; i--) {
            if (res.isEmpty()) {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                int[] temp = res.get(res.size() - 1);   // 获得上一个已经合并的区间
                if (temp[0] > intervals[i][1]) {    // 如果已经合并的第二个坐标比准备插入的坐标小，则插入准备插入的
                    res.add(new int[]{intervals[i][0], intervals[i][1]});
                } else {    // 否则新建数组
                    res.get(res.size() - 1)[0] = Math.min(temp[0], intervals[i][0]);
                    res.get(res.size() - 1)[1] = Math.max(temp[1], intervals[i][1]);
                }
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    /**
     * 按照数组的第一个下标排序
     *
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        return null;
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }

}
