package Tree.PreorderAPP;

import Tree.TreeNode;

import java.util.Map;

public class lc111 {

    /**
     * My Solution
     */
    private int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root){
        if (root == null) return  0;
        helper(root,0);
        return res;
    }

    public void helper(TreeNode root,int depth){
        if (root == null) return;
        if (root.left == null && root.right == null){
            depth = depth +1;
            res = Math.min(depth,res);
        }
        depth = depth+1;
        helper(root.left,depth);
        helper(root.right,depth);
    }

    /**
     * Answer
     */
    public static  int minDepth1(TreeNode root){
        if (root == null) return  0;
        if (root.left == null || root.right == null) {
            return Math.max(minDepth1(root.left), minDepth1(root.right))+1;
        }
        return Math.min(minDepth1(root.left),minDepth1(root.right))+1;
    }
}
