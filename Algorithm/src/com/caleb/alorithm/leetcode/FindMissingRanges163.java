package com.caleb.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 缺失的区间
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 *
 * @author：hanzhigang
 * @Date : 2021/5/7 11:06 PM
 */
public class FindMissingRanges163 {

    /**
     * 遍历
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            if(lower == upper){
                res.add(lower+"");
            }else{
                res.add(lower+"->"+upper);
            }
            return res;
        }

        int pre = nums[0];
        int cur;
        if(pre != lower){
            String s;
            if (pre - 1 != lower) {
                s = lower+"->"+(pre-1);
            }else{
                s = pre-1+"";
            }
            res.add(s);
        }
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if (cur - pre > 1) {
                String s;
                if (pre + 1 != cur - 1) {
                    s = (pre+1)+"->"+(cur-1);
                }else{
                    s = pre+1+"";
                }
                res.add(s);
            }
            pre = nums[i];
        }
        if (upper != pre) {
            String s;
            if (pre + 1 != upper) {
                s = (pre+1)+"->"+upper;
            }else{
                s = pre+1+"";
            }
            res.add(s);
        }
        return res;
    }
}
