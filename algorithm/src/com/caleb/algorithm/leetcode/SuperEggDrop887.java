package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-16 18:35:05
 * 
 *       鸡蛋掉落
 * 
 *       给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * 
 *       已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 
 *       每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 
 *       如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 
 *       请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 */
public class SuperEggDrop887 {

	/**
	 * 动态规划 不能用DPTABLE来做，需要用备忘录的方式来做
	 * 
	 * 超时
	 * 
	 * @param k k个鸡蛋
	 * @param n n层
	 * @return
	 */
	Map<String, Integer> memo = new HashMap<>();

	public int superEggDrop(int k, int n) {
		return dp(k, n);
	}

	private int dp(int k, int n) {
		if (k == 1) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		String key = k + "," + n;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			res = Math.min(res, Math.max(dp(k - 1, i - 1), dp(k, n - i)) + 1);
		}
		memo.put(key, res);
		return res;
	}

	public int superEggDrop1(int k, int n) {
		return dp1(k, n);
	}

	/**
	 * k个鸡蛋，n层楼
	 * 
	 * @param k
	 * @param n
	 * @return
	 */
	private int dp1(int k, int n) {
		if (memo.containsKey(k + "," + n)) {
			return memo.get(k + "," + n);
		}
		if (k == 1) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		int res = 0;
		int left = 1, right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			// 如果在当前层鸡蛋碎了
			int ls = dp1(k - 1, mid - 1);
			// 如果在当前层鸡蛋没碎
			int hs = dp1(k, n - mid);
			if (ls > hs) {
				right = mid - 1;
			} else if (hs > ls) {
				left = mid + 1;
			} else {
				left = right = mid;
			}
		}
		res = 1 + Math.min(Math.max(dp1(k - 1, left - 1), dp1(k, n - left)),
				Math.max(dp1(k - 1, right - 1), dp1(k, n - right)));
		memo.put(k + "," + n, res);
		return res;
	}

	public static void main(String[] args) {
		SuperEggDrop887 superEggDrop887 = new SuperEggDrop887();
		System.out.println(superEggDrop887.superEggDrop(1, 2));
	}

}