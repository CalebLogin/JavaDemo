package com.caleb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import com.caleb.demo.TreeNode;

/**
 * @author:Caleb
 * @Date :2021-06-18 11:18:19
 */
public class Codec297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                builder.append("null,");
            } else {
                builder.append(String.valueOf(node.val) + ",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return builder.substring(0, builder.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "null"){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.add(root);
        int strIndex = 1;
        int strsLen = strs.length;
        while(strIndex < strsLen){
            TreeNode node = q.poll();
            if(!strs[strIndex].equals("null")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(strs[strIndex]));
                node.left = leftNode;
                q.add(leftNode);
            }
            strIndex++;
            if(!strs[strIndex].equals("null")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(strs[strIndex]));
                node.right = rightNode;
                q.add(rightNode);
            }
            strIndex++;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec297 c = new Codec297();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(c.serialize(node1));

        TreeNode root = c.deserialize(c.serialize(node1));
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }

}