package com.caleb.algorithm.review;

/**
 * 有n个鱼塘按顺序排成一排，第1≤i≤n个鱼塘有a[i]条鱼，在第i个鱼塘,每捕捞一条鱼需要消耗cost[i]的体力。
 * 一开始你的体力值为w，同时这也是你的体力上限(体力需要一直保证大于等于0)。
 * 每捕捞一条鱼你的体力上限会增加b,你从一个鱼塘走到下一个鱼塘体力恢复x。
 * 你一开始在1号鱼塘，你必须按照顺序走到n号鱼塘去，中途不能回头。问你在这个过程中最多能捕捉多少条鱼。
 * 第一行四个整数n，w, b, x(1 ≤n≤200,1 ≤w,b,x≤10^9)
 * 第二行几个整数a[i](1≤a[i]≤10)。
 * 第三行几个整数cost[i](1≤ cost[i] ≤10^9)
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