package com.caleb.algorithm.review.offerdemo;

import com.caleb.algorithm.leetcode.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-08-04 16:57:19
 */
public class IsSubStructure26 {

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(B == null){
			return false;
		}
		return isSubStructure(A.left, B) || isSubStructure(A.right, B) || judgeIsSubStructure(A, B);
		
	}

	public boolean judgeIsSubStructure(TreeNode A, TreeNode B) {
		if(A != null && B != null){
			if(A.val == B.val){
				return judgeIsSubStructure(A.left, B.left) && judgeIsSubStructure(A.right, B.right);
			}else{
				return false;
			}
		}else if(A == null && B != null){
			return false;
		}
		return true;
	}

}