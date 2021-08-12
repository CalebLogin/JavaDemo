package com.caleb.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author：hanzhigang
 * @Date : 2021/5/30 10:17 AM
 */
public class IsPowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<31;i++){
            set.add((int)Math.pow(2,i));
        }
        if(set.contains(n)){
            return true;
        }
        return false;
    }
    public boolean isPowerOfTwo1(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }
    public boolean isPowerOfTwo2(int n){
        return n > 0 && (n & (-n)) == n;
    }
}
