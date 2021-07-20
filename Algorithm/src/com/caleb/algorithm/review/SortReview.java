package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-07-19 22:40:45
 */
public class SortReview {

	/**
	 * 直接插入排序
	 * 
	 * @param nums
	 */
	public void insertSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int j = 0;
			int num = nums[i];
			for (; j < i; j++) {
				if (nums[j] > nums[i]) {
					break;
				}
			}
			for (int k = i; k > j; k--) {
				nums[k] = nums[k - 1];
			}
			nums[j] = num;
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param nums
	 */
	public void selectSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int min = nums[i];
			for (int j = i; j < nums.length; j++) {
				min = Math.min(min, nums[j]);
			}
			nums[i] = min;
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param nums
	 */
	public void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			boolean flag = true;
			for (int j = nums.length - 1; j > i; j++) {
				if (nums[j - 1] > nums[j]) {
					swap(nums, j - 1, j);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param nums
	 */
	public void quickSort(int[] nums) {
		quickSortMid(nums, 0, nums.length - 1);
	}

	private void quickSortMid(int[] nums, int left, int right) {
		if (left < right) {
			int num = nums[left];
			int l = left, r = right;
			while (l < r) {
				while (l < r && nums[r] > num) {
					r--;
				}
				if (l < r) {
					nums[l++] = nums[r];
				}
				while (l < r && nums[l] < num) {
					l++;
				}
				if (l < r) {
					nums[r--] = nums[l];
				}
			}
			nums[l] = num;
			quickSortMid(nums, left, l - 1);
			quickSortMid(nums, l + 1, right);
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param nums
	 */
	public void mergeSort(int[] nums) {
		mergeSortMid(nums, 0, nums.length - 1);
	}

	private void mergeSortMid(int[] nums, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSortMid(nums, l, mid);
			mergeSortMid(nums, mid + 1, r);
			int lIndex = l;
			int rIndex = r;
			int index = 0;
			int[] tempArr = new int[r - l + 1];
			while (index < r - l + 1 && lIndex <= mid && rIndex < r) {
				if (nums[lIndex] <= nums[rIndex]) {
					tempArr[index++] = nums[lIndex++];
				} else {
					tempArr[index++] = nums[rIndex++];
				}
			}
			while (lIndex <= mid) {
				tempArr[index++] = nums[lIndex++];
			}
			while (rIndex <= r) {
				tempArr[index++] = nums[rIndex++];
			}
			for (int i = l; i <= r; i++) {
				nums[i] = tempArr[i - l];
			}
		}

	}

	/**
	 * 堆排序
	 * 
	 * @param nums
	 */
	public void heapSort(int[] nums) {
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			heapSortAdjust(nums, i, nums.length);
		}
		for (int i = nums.length - 1; i > 0; i--) {
			swap(nums, i, 0);
			heapSortAdjust(nums, i, nums.length);
		}
	}

	private void heapSortAdjust(int[] nums, int pos, int end) {
		int p = pos;
		int l = p * 2 + 1;
		for (; l < end; p = l, l = l * 2 + 1) {
			if (l + 1 < end && nums[l + 1] < nums[l]) {
				l++;
			}
			if (nums[l] >= nums[p]) {
				break;
			} else {
				swap(nums, l, p);
			}
		}
	}

	/**
	 * 希尔排序
	 * 
	 * @param nums
	 */
	public void shellSort(int[] nums) {
		int gap;
		for (gap = nums.length / 2; gap > 0; gap--) {
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < nums.length; j++) {
					if(nums[j - gap] > nums[j]){
						int temp = nums[j];
						int k = j - gap;
						while(k >= i && nums[k] > temp){
							nums[k + gap] = nums[k];
							k -= gap;
						}
						nums[k + gap] = temp;
					}
				}
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}