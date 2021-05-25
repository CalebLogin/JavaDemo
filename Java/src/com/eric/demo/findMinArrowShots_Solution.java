package com.eric.demo;

import java.util.Arrays;

/**
 * @author：hanzhigang
 * @Date : 2020/11/23 10:04 AM
 */
public class findMinArrowShots_Solution {
    public int findMinArrowShots(int[][] points) {

        if(points.length == 0) {
            return 0;
        }
//        按照气球位置的最右边进行升序排序
        Arrays.sort(points,(p1,p2) -> p1[1] < p2[1] ? -1 : 1);

        int num = 1;
        int pre = points[0][1];
        for(int[] item:points){
            if(item[0] > pre){
                num++;
                pre = item[1];
            }
        }
        return num;
    }
}
