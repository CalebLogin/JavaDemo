package com.caleb.algorithm.review;

import java.util.Scanner;

/**
 * 电车简单题 电车的路线表示为一颗有n个节点的有根树。 根节点是电车的起点，每一个非叶子结点表示一个分叉路口，而每一个叶子节点表示一个终点站。
 * 每一条边上放置有一定数目的标志物，一辆电车从起点出发， 每到一个节点就等概率地随机向它儿子节点驶去，直到驶入终点站才停下。
 * 求这辆电车经过路径上所有边标志物数目总和的期望值是多少。
 * 标志物数目的期望值是：对于电车每种可能经过的路径，算出它们的概率与标志物总数的乘积，最后把所有路径的这个乘积相加。
 * 
 * @author:Caleb
 * @Date :2021-06-16 08:56:21
 */
public class Trolleybus3 {

	public double trolleybus() {
		double res = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// node[i]的值fi表示为节点i的父节点是node fi
		int[] nodes = new int[n];
		nodes[0] = 1;
		// singals[i] 表示到达 节点i 的路径上的标志物个数
		int[] singals = new int[n];
		// 记录每个节点的子节点个数
		int[] nodeOfChildCount = new int[n];
		// 达到当前节点的概率值，存储其分母
		int[] arriveNodeProbability = new int[n];
		arriveNodeProbability[0] = 1;

		for (int i = 1; i < n; i++) {
			nodes[i] = sc.nextInt();
		}
		for (int i = 1; i < n; i++) {
			singals[i] = sc.nextInt();
		}
		sc.close();

		// 找到每一个节点的子节点的个数，并计算到达该节点所需要的概率，存储其分母
		int left = 1, right = 1;
		while (right < n) {
			if (nodes[left] == nodes[right]) {
				right++;
			} else {
				nodeOfChildCount[nodes[left] - 1] = right - left;
				left = right;
			}
		}
		nodeOfChildCount[nodes[left] - 1] = right - left;

		// 每个子节点的概率值分母等于父节点的子节点个数 * 父节点的概率值分母
		for (int i = 1; i < n; i++) {
			arriveNodeProbability[i] = nodeOfChildCount[nodes[i]-1] * arriveNodeProbability[nodes[i]-1];
			res += singals[i] / (double)arriveNodeProbability[i];
		}
		return Math.round(res * 1000000) / 1000000.0;
	}

	public static void main(String[] args) {
		Trolleybus3 trolleybus3 = new Trolleybus3();
		System.out.println(trolleybus3.trolleybus());
	}

}
