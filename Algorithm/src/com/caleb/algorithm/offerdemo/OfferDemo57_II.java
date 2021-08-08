package com.caleb.algorithm.offerdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * @author：hanzhigang
 * @Date : 2021/3/16 10:24 PM
 */
public class OfferDemo57_II {
    /**
     * 思路1：滑动窗口，在找到第一组符合条件之后，每次滑动窗口的大小减一
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int start = 1, end = (target / 2) + (target % 2 == 0 ? 0 : 1);
        int step = 2;
        while (start < step && step <= end) {
            if (count(start, step) == target) {
                int[] res = new int[step-start+1];
                for(int i=start;i<=step;i++){
                    res[i-start] = i;
                }
                list.add(res);
                start++;
                step++;
            } else if (count(start, step) < target) {
                step++;
            } else {
                start++;
//                step--;
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public int count(int start, int step) {
        return ((start + step) * (step - start + 1)) / 2;
    }

    public static void main(String[] args) {
        OfferDemo57_II offerDemo57_ii = new OfferDemo57_II();
        offerDemo57_ii.findContinuousSequence(9);
    }
}
