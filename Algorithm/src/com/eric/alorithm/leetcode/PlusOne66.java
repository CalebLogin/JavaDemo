package com.eric.alorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 加一
 *
 * @author：hanzhigang
 * @Date : 2021/4/9 6:22 PM
 */
public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
