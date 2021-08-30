package com.caleb.pdd;

import java.util.Arrays;

public class Main10 {

	public static boolean is_overlap(int[][] lines) {
		int n = lines.length;
		if(n <= 1){
			return false;
		}
		for (int i = 0; i < n; i++) {
			if (lines[i][0] > lines[i][1]) {
				int temp = lines[i][0];
				lines[i][0] = lines[i][1];
				lines[i][1] = temp;
			}
		}
		Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);
		for(int i = 1;i<n;i++){
			int[] line0 = lines[i-1];
			int[] line1 = lines[i];
			if(line0[1] >= line1[0]){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(is_overlap(new int[][]{{1,2},{3,4},{-1,-2},{-1,2}}));
	}

}
