package com.caleb.algorithm.leetcode;


/**
 * @author:Caleb
 * @Date  :2021-06-14 22:54:29
 */
public class IncreasingTriplet334{

	/**
	 * 贪心
	 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/solution/cyi-ge-tan-xin-de-approach-ceng-ceng-tui-fjfy/
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
		if(nums.length < 3){
			return false;
		}
		int l = 0,m = 0;
		for(int i = 0;i<nums.length;i++){
			if(nums[i] < nums[l]){
				l = i;
			}
			if(nums[i] > nums[m] && m != 0){
				return true;
			}
			if(nums[i] > nums[l]){
				m = i;
			}
		}
		return false;
    }

	public static void main(String[] args) {
		IncreasingTriplet334 increasingTriplet334 = new IncreasingTriplet334();
		System.out.println(increasingTriplet334.increasingTriplet(new int[]{2,1,5,0,4,6}));
	}

}
