package com.caleb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author:Caleb
 * @Date :2021-07-30 19:14:13
 */
public class Main {

	public int countMaxActivity(List<List<String>> timeSchedule) {
		int maxRes = 0;
		Set<int[]> filterdSchedule = new TreeSet<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}

		});
		for (List<String> strs : timeSchedule) {
			String pre = strs.get(0).replace(":", "");
			int preI = Integer.valueOf(pre);
			String next = strs.get(1).replace(":", "");
			int nextI = Integer.valueOf(next);
			filterdSchedule.add(new int[] { preI, nextI });
		}
		List<int[]> schedules = new ArrayList<>(filterdSchedule);
		int[] dp = new int[schedules.size()];
		dp[0] = 1;
		for (int i = 1; i < schedules.size(); i++) {
			int currMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if(schedules.get(i)[0] >= schedules.get(j)[1]){
					currMax = Math.max(currMax, dp[j]);
				}
			}
			dp[i] = currMax + 1;
			maxRes = Math.max(dp[i], maxRes);
		}
		
		return maxRes;
	}

	public int findMin(int[][] mapArray) {
		int row = mapArray.length;
		int col = mapArray[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = mapArray[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + mapArray[i][0];
		}
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + mapArray[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + mapArray[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	public int[] max_version(String[][] version_list) {
		// write code here
		int[] res = new int[version_list.length];
		int pos = 0;
		for (String[] versions : version_list) {
			String version1 = versions[0];
			String version2 = versions[1];

			String[] versions1 = compareVersion(version1);
			String[] versions2 = compareVersion(version2);
			int comV = 1;
			for (int i = 0; i < 4; i++) {
				int v1 = Integer.valueOf(versions1[i]);
				int v2 = Integer.valueOf(versions2[i]);
				if (v1 < v2) {
					comV = 2;
					break;
				} else if (v1 > v2) {
					comV = 1;
					break;
				}
			}
			res[pos++] = comV;

		}
		return res;
	}

	private String[] compareVersion(String version) {
		int l = 0, r = 0, i = 0;
		String[] versions = new String[4];
		Arrays.fill(versions, "0");
		while (r < version.length()) {
			if (version.charAt(r) != '.') {
				r++;
			} else {
				String subS = version.substring(l, r);
				versions[i++] = subS;
				l = r + 1;
				r = r + 1;
			}
		}
		if (l < r) {
			String subS = version.substring(l, r);
			versions[i] = subS;
		}
		return versions;
	}

	public static void main(String[] args) {
		List<List<String>> aa = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("10:00");
		list1.add("12:00");
		List<String> list2 = new ArrayList<>();
		list2.add("03:00");
		list2.add("11:30");
		List<String> list3 = new ArrayList<>();
		list3.add("11:30");
		list3.add("14:00");
		List<String> list4 = new ArrayList<>();
		list4.add("11:30");
		list4.add("14:00");
		aa.add(list1);
		aa.add(list2);
		aa.add(list3);
		aa.add(list4);
		Main m = new Main();
		System.out.println(m.countMaxActivity(aa));
	}

}