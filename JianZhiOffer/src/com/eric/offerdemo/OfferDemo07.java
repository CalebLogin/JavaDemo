package com.eric.offerdemo;

/**
 * @author：hanzhigang
 * @Date : 2021/3/2 9:57 AM
 */
public class OfferDemo07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        /*TreeNode node = null;
//      记录左子树元素的个数和右子树元素的个数
        int leftIndex = 0;
//      如果前序遍历数组不为空，说明还有节点
        if(preorder.length != 0){
            node = new TreeNode(preorder[0]);
//          找到当前子树的根结点在中序遍历中的位置，根结点左边为左子树，右边为右子树
            for(;leftIndex<inorder.length;leftIndex++){
//              leftIndex为当前子树根结点在中序遍历数组中的位置
                if(inorder[leftIndex] == preorder[0]){
                    break;
                }
            }

//          找到前序遍历和中序遍历的子树遍历数组
            int[] preorder1 = new int[leftIndex];
            int[] preorder2 = new int[preorder.length-(leftIndex+1)];
            int[] inorder1 = new int[leftIndex];
            int[] inorder2 = new int[preorder.length-(leftIndex+1)];
            for(int i=0;i<leftIndex;i++){
                preorder1[i] = preorder[i+1];
                inorder1[i] = inorder[i];
            }
            for(int i=0;i<preorder.length-(leftIndex+1);i++){
                preorder2[i] = preorder[i+leftIndex+1];
                inorder2[i] = inorder[i+leftIndex+1];
            }

//          接着寻找当前节点的左子树和右子树
            node.left = buildTree(preorder1,inorder1);
            node.right = buildTree(preorder2,inorder2);

        }
        return node;*/
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        return buildTree1(preorder,inorder,0,n-1,0,n-1);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder,int leftStart,int leftEnd,int rightStart,int rightEnd) {

        TreeNode node = null;
//      记录左子树元素的个数和右子树元素的个数
        int index = rightStart;
//      如果前序遍历数组不为空，说明还有节点
        if(leftStart<=leftEnd){
            node = new TreeNode(preorder[leftStart]);
//          找到当前子树的根结点在中序遍历中的位置，根结点左边为左子树，右边为右子树
            for(;index<rightEnd;index++){
//              leftIndex为当前子树根结点在中序遍历数组中的位置
                if(inorder[index] == preorder[leftStart]){
                    break;
                }
            }

//          接着寻找当前节点的左子树和右子树
            node.left = buildTree1(preorder,inorder,leftStart+1,leftStart+index-rightStart,rightStart,index-1);
            node.right = buildTree1(preorder,inorder,leftStart+index-rightStart+1,leftEnd,index+1,rightEnd);

        }
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        OfferDemo07 offerDemo07 = new OfferDemo07();
        TreeNode head = offerDemo07.buildTree(preorder,inorder);
        System.out.println(head.right.val);
    }

}
