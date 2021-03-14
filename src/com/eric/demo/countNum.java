package demo;


/**
 * @author：hanzhigang
 * @Date : 2020/11/29 11:38 PM
 * 求完全二叉树的节点个数
 */
public class countNum {

    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        TreeNode node = root;
//        求出完全二叉树的深度
        int depth = 0;
        while(node.left != null){
            depth++ ;
            node = node.left;
        }
//        设定最大层的只有一个节点leftnode，或者最大层是满节点，最右边节点rightnode
        int leftnode = 1<<depth,rightnode = (1<<(depth+1))-1;
//        二分查找，判断是否存在当前中间节点
        while(leftnode < rightnode){
            int mid = (rightnode - leftnode + 1) / 2 + leftnode;
            if(exits(depth,root,mid)){
                leftnode = mid;
            }else{
                rightnode = mid - 1;
            }
        }
        return leftnode;
    }

    /**
     * 输入完全二叉树的深度，根节点，当前中间节点的值
     * 将上一层的最左侧节点与当前中间节点进行比较，比较值等于0，节点向左走，否则向右走
     * @param depth
     * @param root
     * @param k
     * @return
     */
    public boolean exits(int depth,TreeNode root,int k){
        TreeNode node = root;
        int bits = 1 << (depth-1);
        while(node != null && bits > 0){
            if((bits & k) ==0){
                node = node.left;
            }else{
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
