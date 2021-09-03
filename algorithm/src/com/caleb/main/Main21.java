package com.caleb.main;

public class Main21 {

	public int diskRead(int[] a, int pos) {
		int minPos = Integer.MAX_VALUE;
		int maxPos = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			minPos = Math.min(minPos, a[i]);
			maxPos = Math.max(maxPos, a[i]);
		}
		if (pos < minPos) {
			return maxPos - pos;
		}
		if (pos > maxPos) {
			System.out.println(pos - minPos);
		}
		return  Math.min(pos - minPos, maxPos - pos) + maxPos - minPos;
	}

	public static void main(String[] args) {
		
	}

}