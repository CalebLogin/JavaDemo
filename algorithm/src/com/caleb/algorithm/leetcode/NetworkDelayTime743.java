package com.caleb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author:Caleb
 * @Date :2021-08-02 21:07:18
 * 
 *       网络延迟时间
 * 
 *       有 n 个网络节点，标记为 1 到 n。
 * 
 *       给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi,
 *       wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 
 *       现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * 
 */
public class NetworkDelayTime743 {

	int N = 110, M = 6010;
	int[][] w = new int[N][N];
	int[] dist = new int[N];
	boolean[] vis = new boolean[N];
	int INF = 0x3f3f3f3f;
	int n, k;

	public int networkDelayTime(int[][] ts, int _n, int _k) {
		n = _n;
		k = _k;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				w[i][j] = w[j][i] = i == j ? 0 : INF;
			}
		}
		for (int[] t : ts) {
			int u = t[0], v = t[1], c = t[2];
			w[u][v] = c;
		}
		dijkstra();
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dist[i]);
		}
		return ans > INF / 2 ? -1 : ans;
	}

	void dijkstra() {
		Arrays.fill(vis, false);
		Arrays.fill(dist, INF);
		dist[k] = 0;
		for (int p = 1; p <= n; p++) {
			int t = -1;
			for (int i = 1; i <= n; i++) {
				if (!vis[i] && (t == -1 || dist[i] < dist[t]))
					t = i;
			}
			vis[t] = true;
			for (int i = 1; i <= n; i++) {
				dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
			}
		}
	}

}