package com.caleb.main;
import java.util.*;

/**
 * @author：hanzhigang
 * @Date : 2021/4/9 7:11 PM
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] res;
        int t = sc.nextInt();
        res = new int[t][][];
        // 输入
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            res = new int[t][][];
            for (int j = 0; j < n; j++) {
                int l1 = sc.nextInt();
                int l2 = sc.nextInt();
                res[i][j][0] = l1;
                res[i][j][1] = l2;
            }
        }

        for (int i = 0; i < res.length; i++) {
            int[][] res1 = res[i];
            Arrays.sort(res1, Comparator.comparingInt((o) -> o[0]));
            int l = 1, r = 0;
            while (r < res.length) {
                if (res1[r][1] >= l) {
                    System.out.print(l + " ");
                    ++l;
                } else {
                    System.out.print(0 + " ");
                }
                r++;
            }
            if (i < res.length - 1) {
                System.out.println();
            }

        }
        sc.close();
    }
}
