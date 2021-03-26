package com.eric.alorithm.codetop;

import com.eric.offerdemo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 思路：层序遍历每层的最后一个节点
 * @author：hanzhigang
 * @Date : 2021/3/25 11:21 PM
 */
public class RightSideView199 {


    public List<Integer> rightSideView(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        // 记录每层的节点个数
        int size;
        // 定义链表存放每层的节点个数
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        // 定义返回结果
        List<Integer> res = new ArrayList<>();
        TreeNode temp;

        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            size = linkedList.size();
            for(int i = 0;i<size;i++){
                temp = linkedList.pollFirst();
                if(i == size - 1) res.add(temp.val);
                if(temp.left != null) linkedList.addLast(temp.left);
                if(temp.right != null) linkedList.addLast(temp.right);
            }
        }
        return res;

    }


}
