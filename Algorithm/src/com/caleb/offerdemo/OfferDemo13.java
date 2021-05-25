package com.eric.offerdemo;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @author：hanzhigang
 * @Date : 2021/3/3 10:56 PM
 */
public class OfferDemo13 {

    //  行数和列数
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {

        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];

        return dfs(0, 0, 0, 0);
    }

    //  深度优先遍历
    public int dfs(int i, int j, int s1, int s2) {
//      如果数组越界或者已经访问过或者不符合数位和条件返回0
        if (i >= m || j >= n || visited[i][j] || k < s1 + s2) {
            return 0;
        }
//      访问标记
        visited[i][j] = true;
//      进行下一步遍历并返回值
        return 1 + dfs(i + 1, j, numCalculate(i + 1), numCalculate(j))
                + dfs(i, j + 1, numCalculate(i), numCalculate(j + 1));

    }

    //  广度优先搜索
    public int movingCount1(int m, int n, int k) {
//      已经访问数组
        boolean[][] visited = new boolean[m][n];
//      能够访问格子的数量
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});

        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], s1 = x[2], s2 = x[3];
//          如果数组越界或者已经访问过或者不符合数位和条件继续while循环
            if (i >= m || j >= n || visited[i][j] || k < s1 + s2) continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i,j+1,numCalculate(i),numCalculate(j+1)});
            queue.add(new int[]{i+1,j,numCalculate(i+1),numCalculate(j)});

        }
        return res;
    }

    //  计算数位和
    public int numCalculate(int num) {
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }
        return temp;
    }




}
