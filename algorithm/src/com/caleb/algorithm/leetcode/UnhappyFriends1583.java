package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-08-14 21:44:05
 * 
 *       统计不开心的朋友
 * 
 *       给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 * 
 *       对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i
 *       的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 * 
 *       所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与
 *       xi 配对。
 * 
 *       但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x
 *       就会不开心：
 * 
 *       x 与 u 的亲近程度胜过 x 与 y，且 u 与 x 的亲近程度胜过 u 与 v 返回 不开心的朋友的数目 。
 * 
 * 
 */
public class UnhappyFriends1583 {

	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		int res = 0;
		Map<Integer, Integer> pairsCol = new HashMap<>();
		Map<Integer, Set<Integer>> shouldUnHappy = new HashMap<>();
		for (int[] pair : pairs) {
			pairsCol.put(pair[0], pair[1]);
			Set<Integer> unhappyList = new HashSet<>();
			int[] preference = preferences[pair[0]];
			for (int i = 0; i < n - 1 && preference[i] != pair[1]; i++) {
				unhappyList.add(preference[i]);
			}
			shouldUnHappy.put(pair[0], unhappyList);
			pairsCol.put(pair[1], pair[0]);
			unhappyList = new HashSet<>();
			preference = preferences[pair[1]];
			for (int i = 0; i < n - 1 && preference[i] != pair[0]; i++) {
				unhappyList.add(preference[i]);
			}
			shouldUnHappy.put(pair[1], unhappyList);

		}
		for (int i = 0; i < n; i++) {
			Set<Integer> unhappyList = shouldUnHappy.get(i);
			for (Integer pri : unhappyList) {
				if (shouldUnHappy.get(pri).contains(i)) {
					res++;
					break;
				}
			}
		}
		return res;

	}

	public int unhappyFriends1(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
	public static void main(String[] args) {
		UnhappyFriends1583 u = new UnhappyFriends1583();
		System.out.println(u.unhappyFriends(4, new int[][] { { 1, 3, 2 }, { 2, 3, 0, }, { 1, 3, 0 }, { 0, 2, 1 } },
				new int[][] { { 1, 3 }, { 0, 2 } }));
	}

}