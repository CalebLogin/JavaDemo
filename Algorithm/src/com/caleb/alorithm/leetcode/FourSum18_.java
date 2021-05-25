package com.eric.alorithm.leetcode;

import java.util.*;

/**
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 *
 * @author：hanzhigang
 * @Date : 2021/4/4 6:10 PM
 */
public class FourSum18_ {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 对nums进行排序
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        // 数组中的任意两数之和存放在哈希中
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int totalNum = nums[i] + nums[j];   // 两数之和
                if (!map.containsKey(totalNum)) {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    map.put(totalNum, list);
                } else {
                    map.get(totalNum).add(new int[]{i, j});
                }
            }
        }
        for (Integer num1 : map.keySet()) {
            if (map.containsKey(target - num1)) {
                List<int[]> list1 = map.get(num1);
                List<int[]> list2 = map.get(target - num1);
                for (int[] value : list1) {
                    for (int[] ints : list2) {
                        if (isEqual(value, ints)) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[value[0]]);
                            list.add(nums[value[1]]);
                            list.add(nums[ints[0]]);
                            list.add(nums[ints[1]]);
                            list.sort(Comparator.comparingInt(o -> o));
                            res.add(list);
                        }
                    }
                }
            }
        }
        for(List<Integer> item : res){
            resList.add(item);
        }
        return resList;
    }

    private boolean isEqual(int[] temp1, int[] temp2) {
        return (temp1[0] != temp2[0]) && (temp1[0] != temp2[1]) && (temp1[1] != temp2[0]) && (temp1[1] != temp2[1]);
    }

    public List<List<Integer>> fourSum1(int[] nums, int target){
        return null;
    }

    public static void main(String[] args) {
        FourSum18_ fourSum18 = new FourSum18_();
        System.out.println(fourSum18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
