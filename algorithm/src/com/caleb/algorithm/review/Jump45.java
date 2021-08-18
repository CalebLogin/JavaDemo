package com.caleb.algorithm.review;

/**
 * @author:Caleb
 * @Date :2021-08-18 16:56:28
 */
public class Jump45 {

	/**
	 * 贪心，找到某一个点开始，跳跃范围内能够到达最远的点
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int count = 1;
		int currStart = 0;
		int nextStart = 0;
		int n = nums.length;
		if(n == 1){
			return 0;
		}
		if (nums[0] >= n-1) {
			return 1;
		}
		while (true) {
			int farPos = 0;
			int i = currStart + 1;
			while (i < n && i <= currStart + nums[currStart]) {
				if (nums[i] + i > farPos) {
					nextStart = i;
					farPos = nums[i] + i;
				}
				i++;
			}
			currStart = nextStart;
			count++;
			if (farPos >= n - 1) {
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }));
	}

}