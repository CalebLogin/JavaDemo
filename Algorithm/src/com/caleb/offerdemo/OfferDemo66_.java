package com.caleb.offerdemo;

import java.util.Arrays;

/**
 * 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * @author：hanzhigang
 * @Date : 2021/3/21 10:16 PM
 */
public class OfferDemo66_ {

    public int[] constructArr(int[] a) {
        // 数组a的长度
        int len = a.length;
        // 构建返回数组
        int[] res = new int[a.length];
        // 辅助变量
        int temp = 1;
        Arrays.fill(res,1);
        for (int i = 0; i < len-1; i++) {
            res[i] *= temp;
            temp *= a[i];
        }
        temp = 1;
        for(int i=len-1;i>=0;i--){
            res[i] *= temp;
            temp *= a[i];
        }
        return res;
    }
}
