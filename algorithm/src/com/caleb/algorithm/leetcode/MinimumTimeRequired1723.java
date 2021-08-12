package com.caleb.algorithm.leetcode;

/**
 * @author:Caleb
 * @Date :2021-07-24 15:02:17
 * 
 *       完成所有工作的最短时间
 * 
 *       给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 
 *       请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间
 *       是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 
 *       返回分配方案中尽可能 最小 的 最大工作时间 。
 * 
 */
public class MinimumTimeRequired1723 {

	int[] cnt;
	int maxRes = Integer.MAX_VALUE;

	/**
	 * 朴素回溯 寻找在分配过程中最小的最大值 超时
	 * 
	 * @param jobs
	 * @param k
	 * @return
	 */
	public int minimumTimeRequired(int[] jobs, int k) {

		cnt = new int[k];
		dfs(jobs, 0, 0, k);
		return maxRes;
	}

	private void dfs(int[] jobs, int start, int max, int k) {

		if (max >= maxRes) {
			return;
		}
		if (start == jobs.length) {
			maxRes = max;
			return;
		}

		for (int i = 0; i < k; i++) {
			cnt[i] += jobs[start];
			// 一直保持最大值，然后与最最大值比较，留下较小的那一个
			dfs(jobs, start + 1, Math.max(cnt[i], max), k);
			cnt[i] -= jobs[start];
		}

	}

	public int minimumTimeRequired1(int[] jobs, int k) {

		cnt = new int[k];
		dfs1(jobs, 0, 0, k, 0);
		return maxRes;
	}

	/**
	 * 将工人按序号进行排列
	 * 
	 * @param jobs       所有的工作
	 * @param currWorker 当前工人的序号
	 * @param start      第几个工作
	 * @param k          一共几个工人
	 * @param max        当前工作量的最大值
	 */
	private void dfs1(int[] jobs, int currWorker, int start, int k, int max) {
		if (max >= maxRes) {
			return;
		}
		if (start == jobs.length) {
			maxRes = max;
			return;
		}
		if (currWorker < k) {
			cnt[currWorker] += jobs[start];
			dfs1(jobs, currWorker + 1, start + 1, k, Math.max(cnt[currWorker], max));
			cnt[currWorker] -= jobs[start];
		}
		for (int i = 0; i < currWorker; i++) {
			cnt[i] += jobs[start];
			dfs1(jobs, currWorker, start + 1, k, Math.max(cnt[i], max));
			cnt[i] -= jobs[start];
		}

	}

}