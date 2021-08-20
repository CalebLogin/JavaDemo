package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Caleb
 * @Date :2021-08-20 16:46:25
 * 
 *       自由之路
 * 
 *       电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * 
 *       给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * 
 *       最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00
 *       方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * 
 *       旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * 
 *       您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00
 *       方向对齐，并且这个字符必须等于字符 key[i] 。
 *       如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1
 *       步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * 
 */
public class FindRotateSteps514 {

	/**
	 * 动态规划，截止到第j个字符需要的最小步数
	 * 
	 * @param ring
	 * @param key
	 * @return
	 */
	Map<Character, List<Integer>> charToIndex = new HashMap<>();
	int[][] mimo;

	public int findRotateSteps(String ring, String key) {
		char[] rings = ring.toCharArray();
		char[] keys = key.toCharArray();
		int ringsLen = rings.length;
		for (int i = 0; i < ringsLen; i++) {
			Character c = rings[i];
			List<Integer> list = charToIndex.getOrDefault(c, new ArrayList<>());
			list.add(i);
			charToIndex.put(c, list);
		}
		mimo = new int[ringsLen][keys.length];

		return dp(rings, 0, keys, 0);
	}

	private int dp(char[] rings, int i, char[] keys, int j) {
		if (j == keys.length) {
			return 0;
		}
		if (mimo[i][j] != 0) {
			return mimo[i][j];
		}
		int n = rings.length;
		int res = Integer.MAX_VALUE;
		for (Integer num : charToIndex.get(keys[j])) {
			int delta = Math.abs(num - i);
			delta = Math.min(delta, n - delta);
			int subPro = dp(rings, num, keys, j + 1);
			res = Math.min(res, 1 + subPro + delta);
		}
		mimo[i][j] = res;
		return res;

	}

	public static void main(String[] args) {
		FindRotateSteps514 f = new FindRotateSteps514();
		System.out.println(f.findRotateSteps("godding", "godding"));
	}
}