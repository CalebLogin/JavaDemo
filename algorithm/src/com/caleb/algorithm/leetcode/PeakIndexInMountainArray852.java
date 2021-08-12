package com.caleb.algorithm.leetcode;

/**
 * 山脉数组的封顶索引 符合下列属性的数组 arr 称为 山脉数组 ：arr.length >= 3 存在 i（0 < i < arr.length -
 * 1）使得： arr[0] < arr[1] < ... arr[i-1] < arr[i]， arr[i] > arr[i+1] > ... >
 * arr[arr.length - 1] 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1]
 * < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * 
 * @author:Caleb
 * @Date :2021-06-15 10:33:13
 */
public class PeakIndexInMountainArray852 {

	/**
	 * 顺序查找
	 * 
	 * @param arr
	 * @return
	 */
	public int peakIndexInMountainArray(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len - 1; i++) {
			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 二分法
	 * 
	 * @param arr
	 * @return
	 */
	public int peakIndexInMountainArray1(int[] arr) {
		int len = arr.length;
		int l = 0, r = len - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if(arr[mid] < arr[mid+1]){
				l = mid+1;
			}else if(arr[mid] > arr[mid + 1]){
				r = mid;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		PeakIndexInMountainArray852 peakIndexInMountainArray852 = new PeakIndexInMountainArray852();
		System.out.println(peakIndexInMountainArray852.peakIndexInMountainArray1(new int[]{3,4,5,1}));
	}

}