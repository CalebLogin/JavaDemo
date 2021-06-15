package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-06-15 15:29:06
 */
public class Fishpond {

	private int maxTotal = Integer.MIN_VALUE;
	private int[] a;
	private int[] cost;
	private int b;
	private int x;

	/**
	 * 求鱼的最大条数
	 * 
	 * @param a    第i个鱼塘有多少条鱼
	 * @param cost 在第i个鱼塘捕1条鱼需要消耗的体力
	 * @param n    鱼塘个数
	 * @param w    一开始的体力值
	 * @param b    体力上限增加量
	 * @param x    走到下一个鱼塘体力恢复值
	 * @return
	 */
	public int fishpond(int[] a, int[] cost, int n, int w, int b, int x) {
		this.b = b;
		this.a = a;
		this.x = x;
		this.cost = cost;
		int physicV = w;
		int leftV = w;
		helper(physicV, leftV, 0, 0);
		return maxTotal;
	}

	/**
	 * 
	 * @param physicV 体力值上限
	 * @param leftV   剩余体力值
	 * @param end     到达鱼塘的位置
	 * @param total   捕到鱼的总数
	 */
	private void helper(int physicV, int leftV, int end, int total) {
		/**
		 * 说明走完了全部鱼塘，计算总值
		 */
		if (end == a.length) {
			maxTotal = Math.max(maxTotal, total);
			return;
		}
		int maxSize = leftV / cost[end];
		maxSize = Math.min(maxSize, a[end]);
		for (int i = maxSize; i >= 0; i--) {
			int leftVMost = Math.min(physicV + i * b, leftV - (i * cost[end]) + x);
			helper(physicV + i * b, leftVMost, end + 1, total + i);
		}
	}

	public static void main(String[] args) {
		Fishpond fishpond = new Fishpond();
		int[] a = { 3, 4 };
		int[] cost = { 4, 2 };
		System.out.println(fishpond.fishpond(a, cost, 2, 12, 0, 4));
	}

}