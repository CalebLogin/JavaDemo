package com.eric.alorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * @author：hanzhigang
 * @Date : 2021/4/17 9:51 PM
 */
public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if(j == 0 || j == i){
                    list.add(1);
                }else{
                    list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }

            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Generate118 generate118 = new Generate118();
        System.out.println(generate118.generate(1));
    }
}
