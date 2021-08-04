package com.caleb.algorithm.review.offerdemo;

/**
 * @author:Caleb
 * @Date :2021-08-04 19:20:17
 */
public class VerifyPostorder33 {

	public boolean verifyPostorder(int[] postorder) {
		return verifyOrder(postorder, 0, postorder.length - 1);
	}

	private boolean verifyOrder(int[] postorder, int i, int j) {
		if (i < j) {
			int root = postorder[j];
			int k = j - 1;
			for (; k >= i && postorder[k] >= root; k--)
				;
			for (int m = i; m <= k; m++) {
				if (postorder[m] > root) {
					return false;
				}
			}
			for (int m = j - 1; m > k; m--) {
				if (postorder[m] < root) {
					return false;
				}
			}
			return verifyOrder(postorder, i, k) && verifyOrder(postorder, k + 1, j - 1);
		}
		return true;
	}

}