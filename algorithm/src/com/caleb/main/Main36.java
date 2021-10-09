package com.caleb.main;

/**
 * @author:Caleb
 * @Date :2021-09-26 15:39:26
 */
public class Main36 {

	public static int findN(int n) {
		int digit = 0;
		int index = 0;
		int sd = n / 9;
		int m, i, res = 0; // m 表示还剩几位
		while (index <= sd) {
			digit++;
			index += (Math.pow(10, digit - 1)) * digit;
		}
		//
		index -= (Math.pow(10, digit - 1)) * digit;
		// 在当前digit位数下定位到某一位数
		i = (int) ((Math.pow(10, digit - 1)) + ((n - (index * 9)) / digit)) - 1;
		m = (n - (index * 9)) % digit;
		System.out.println(digit + "," + index + "," + i + "," + m);
		if (m == 0) {
			return i % 10;
		} else {
			int pre = i + 1;
			while (digit != m - 1) {
				res = pre % 10;
				pre /= 10;
				digit--;
			}
			return res;
		}
	}

	public static boolean judgeV(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int startR = 0;
		int startC = n - 1;
		while (startR >= 0 && startR < m && startC >= 0 && startC < n) {
			int num = matrix[startR][startC];
			if (num == target) {
				return true;
			} else if (num < target) {
				startR++;
			} else {
				startC--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str1 = "a";
		String str2= "a";
		String str3 = new String("a");
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		str3 = str3.intern();
		System.out.println(str1 == str3);
	}

}