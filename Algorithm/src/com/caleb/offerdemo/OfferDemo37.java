package com.caleb.offerdemo;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 * @author：hanzhigang
 * @Date : 2021/3/11 4:29 PM
 */
public class OfferDemo37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            stringBuilder.append(curNode.val);
//            if()
        }
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
