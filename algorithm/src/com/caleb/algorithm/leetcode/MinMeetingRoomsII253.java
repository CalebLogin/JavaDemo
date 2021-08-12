package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 会议室II
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免会议冲突，
 * 同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * @author：hanzhigang
 * @Date : 2021/5/30 12:37 AM
 */
public class MinMeetingRoomsII253 {

    /**
     * 排序加列表
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        for (int[] interval : intervals) {
            boolean flag = false;
            for (List<Integer> list : res) {
                if (list.get(list.size() - 1) <= interval[0]) {
                    list.add(interval[1]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<Integer> list = new ArrayList<>();
                list.add(interval[1]);
                res.add(list);
            }
        }
        return res.size();
    }

    /**
     * 双指针
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms1(int[][] intervals) {
        int[] pre = new int[intervals.length];
        int[] post = new int[intervals.length];
        int size = 1;
        int preptr = 1;
        int postptr = 0;
        for (int i = 0; i < intervals.length; i++) {
            pre[i] = intervals[i][0];
            post[i] = intervals[i][1];
        }
        Arrays.sort(pre);
        Arrays.sort(post);
        while (preptr < pre.length) {

            if (pre[preptr] >= post[postptr]) {
                preptr++;
                postptr++;
            } else {
                preptr++;
                size++;
            }

        }
        return size;
    }

    public static void main(String[] args) {
        MinMeetingRoomsII253 minMeetingRoomsII253 = new MinMeetingRoomsII253();
        System.out.println(minMeetingRoomsII253.minMeetingRooms1(new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}));
    }
}
