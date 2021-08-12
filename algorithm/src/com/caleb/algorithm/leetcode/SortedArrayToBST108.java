package com.caleb.algorithm.leetcode;

import com.caleb.algorithm.offerdemo.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author：hanzhigang
 * @Date : 2021/4/16 10:37 PM
 */
public class SortedArrayToBST108 {

    /**
     * 利用递归
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums,l,mid-1);
        node.right = sortedArrayToBSTHelper(nums,mid+1,r);
        return node;
    }

    public static void main(String[] args) {
        SortedArrayToBST108 sortedArrayToBST108 = new SortedArrayToBST108();
        System.out.println(sortedArrayToBST108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).val);
    }
}
