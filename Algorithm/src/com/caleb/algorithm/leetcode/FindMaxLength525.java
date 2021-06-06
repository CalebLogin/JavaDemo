package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * @author：hanzhigang
 * @Date : 2021/6/3 10:41 PM
 */
public class FindMaxLength525 {

    /**
     * 动态规划
     * 二维数组
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                count++;
            }else{
                count--;
            }
            if(map.containsKey(count)){
                max = Math.max(i-map.get(count),max);
            }else{
                map.put(count,i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        FindMaxLength525 findMaxLength525 = new FindMaxLength525();
        System.out.println(findMaxLength525.findMaxLength(new int[]{0, 1}));
    }
}
