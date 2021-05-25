package com.caleb.offerdemo;

/**
 * 二叉树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 思想二，考虑单调栈
 *
 * @author：hanzhigang
 * @Date : 2021/3/9 11:34 PM
 */
public class OfferDemo33 {
    /**
     * 二叉搜索树，如果有左子树，则左子树上的节点都比根结点的值小，如果有右子树，右子树的节点都比根结点的数值大
     * 再根据后序遍历的特性，最后一个节点总是某个子树的根结点，在找到比根结点值大比根结点小的分界点，接着比较，直到比较完所有值。
     *
     * @param postorder 后序遍历数组[1,3,2,6,5]
     * @return 返回是否是二叉搜索树后序遍历的结果。
     */
    public boolean verifyPostorder(int[] postorder) {
//      数组为空，返回false
        if (postorder.length == 0) {
            return true;
        }
        return isPosterOrder(postorder, 0, postorder.length - 1);
    }

    /**
     * 判断子序列是不是二叉搜索树的后序序列
     *
     * @param order      遍历数组
     * @param startIndex 开始位置
     * @param endIndex   结束位置
     * @return
     */
    public boolean isPosterOrder(int[] order, int startIndex, int endIndex) {
//      如果只有一个节点，返回true；
        if (startIndex >= endIndex) {
            return true;
        }
        int root = order[endIndex]; // 根结点的值
        int j = endIndex - 1, i;
//      找到比root小的节点，则右部分是右子树上的，左部分是左子树上的
        while (j >= startIndex && order[j] > root) {
            j--;
        }
        // 如果当前j的位置没有在startIndex，需要判断j之前的部分是不是都比根结点的值小
        if ((++j) != startIndex) {
            i = j - 1;
            while (i >= startIndex && order[i] < root) {
                i--;
            }
//          如果没有遍历到startIndex的位置，则表明出现比根结点的值大的数值，返回false
            if ((++i) != startIndex) {
                return false;
            }
        }
        return j == startIndex ? isPosterOrder(order, startIndex, endIndex - 1) :
                isPosterOrder(order, startIndex, j - 1) && isPosterOrder(order, j, endIndex - 1);
    }

    public static void main(String[] args) {
        int[] order = new int[]{1, 3, 2, 6, 5};
        OfferDemo33 offerDemo33 = new OfferDemo33();
        System.out.println(offerDemo33.verifyPostorder(order));
    }
}
