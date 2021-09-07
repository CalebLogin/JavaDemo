package com.caleb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author:Caleb
 * @Date :2021-09-06 23:08:07
 * 
 *       考场就座
 * 
 *       在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 
 *       当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。
 * 
 *       (另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * 
 *       返回 ExamRoom(int N) 类，它有两个公开的函数：
 * 
 *       其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int
 *       p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * 
 */
public class ExamRoom855 {
	public static void main(String[] args) {
		ExamRoom e = new ExamRoom(4);
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		System.out.println(e.seat());
		e.leave(1);
		e.leave(3);
		e.seat();
	}
}

class ExamRoom {

	Map<Integer, int[]> startMap = new HashMap<>();
	Map<Integer, int[]> endMap = new HashMap<>();
	TreeSet<int[]> treeSet;
	int N;

	public ExamRoom(int n) {
		this.N = n;
		startMap = new HashMap<>(n);
		endMap = new HashMap<>(n);
		treeSet = new TreeSet<>((a, b) -> {
			int disA = distance(a);
			int disB = distance(b);
			if (disA == disB) {
				return b[0] - a[0];
			}
			return disA - disB;
		});
		addInterval(new int[] { -1, N });
	}

	private void addInterval(int[] intV) {
		treeSet.add(intV);
		startMap.put(intV[0], intV);
		endMap.put(intV[1], intV);
	}

	private void removeInterval(int[] intV) {
		treeSet.remove(intV);
		startMap.remove(intV[0]);
		endMap.remove(intV[1]);
	}

	private int distance(int[] intV) {
		int x = intV[0];
		int y = intV[1];
		if (x == -1) {
			return y;
		}
		if (y == N) {
			return N - 1 - x;
		}
		return (y - x) / 2;
	}

	public int seat() {
		int[] longest = treeSet.last();
		int x = longest[0];
		int y = longest[1];
		int seat;
		if (x == -1) {
			seat = 0;
		} else if (y == N) {
			seat = N - 1;
		} else {
			seat = (y - x) / 2 + x;
		}
		int[] left = new int[] { x, seat };
		int[] right = new int[] { seat, y };
		removeInterval(longest);
		addInterval(left);
		addInterval(right);
		return seat;
	}

	public void leave(int p) {
		int[] right = startMap.get(p);
		int[] left = endMap.get(p);
		int[] merged = new int[] { left[0], right[1] };
		removeInterval(right);
		removeInterval(left);
		addInterval(merged);
	}
}