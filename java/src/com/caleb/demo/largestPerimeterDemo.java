package com.caleb.demo;

import java.util.Arrays;

/**
 * @author：hanzhigang
 * @Date : 2020/11/30 12:23 AM
 */
public class largestPerimeterDemo {
    public int largestPerimeter(int[] A) {
        if(A.length <3){
            return 0;
        }
        Arrays.sort(A);
        for(int i = A.length -1;i>=2;i--){
            if(A[i-1] + A[i-2] > A[i]){
                return A[i-1] + A[i-2] + A[i];
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] A = new int[]{1,3,2,4};
        System.out.println(new largestPerimeterDemo().largestPerimeter(A));
    }
}
