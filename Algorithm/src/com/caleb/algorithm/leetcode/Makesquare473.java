package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:Caleb
 * @Date :2021-07-23 19:50:55
 * 
 *       火柴拼正方形
 * 
 *       还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * 
 *       输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * 
 */
public class Makesquare473 {

	int[] cnt;

	public boolean makesquare(int[] matchsticks) {
		if(matchsticks == null || matchsticks.length < 4){
			return false;
		}
		Arrays.sort(matchsticks);
		// 求和
		int sum = 0;
		for (Integer num : matchsticks) {
			sum += num;
		}
		// 如果为奇数，不符合条件
		if (sum % 4 != 0) {
			return false;
		}
		int subSum = sum / 4;
		cnt = new int[4];

		return makesquareHelper(matchsticks, matchsticks.length - 1, subSum);

	}

	private boolean makesquareHelper(int[] mathsticks, int start, int num) {
		if (start == -1) {
			return cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[3];
		}

		for (int i = 0; i < 4; i++) {
			if (cnt[i] + mathsticks[start] <= num) {
				cnt[i] += mathsticks[start];
				if (makesquareHelper(mathsticks, start - 1, num)) {
					return true;
				}
				cnt[i] -= mathsticks[start];
			}
		}
		return false;

	}

	public static void main(String[] args) {
		Makesquare473 m = new Makesquare473();
		int[] matchsticks = { 3, 3, 3, 3, 4 };
		System.out.println(m.makesquare(matchsticks));
	}

}