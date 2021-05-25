package com.caleb.offerdemo;

/**
 * 树的字结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * 遍历A，然后判断B是不是A的子结构
 * 当B为空时，说明是子结构
 * 为A为空B不为空时，遍历到叶子节点，说明当前部分不是子结构
 *
 * @author：hanzhigang
 * @Date : 2021/3/6 6:03 PM
 */
public class OfferDemo26 {
    //  遍历A树来判断是不是子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //  判断是不是子结构
    public boolean helper(TreeNode root1, TreeNode root2) {
//      如果B为空说明遍历完成，是子结构
        if (root2 == null) return true;
//      如果A为空，说明遍历到叶子结点，B仍没有遍历完成，说明当前部分中B不是A的子结构
        if (root1 == null) return false;
//      当前值相同并且接下来的结构也相同
        return (root1.val == root2.val) && helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(1);
        treeNode6.left = treeNode7;
        OfferDemo26 offerDemo26 = new OfferDemo26();
        System.out.println(offerDemo26.isSubStructure(treeNode1, treeNode6));
    }
}
