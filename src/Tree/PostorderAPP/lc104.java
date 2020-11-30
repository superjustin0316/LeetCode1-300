package Tree.PostorderAPP;

import Tree.TreeNode;

import java.util.Map;

public class lc104 {
    /**
     * My Solution
     */
    private int res = Integer.MIN_VALUE;
    public int maxDepth1(TreeNode root){
        if (root == null) return  0;
        helper(root,0);
        return res;
    }
    public void helper(TreeNode root,int depth){
        if (root == null) return;
        if (root.left == null && root.right == null){
            depth = depth +1;
            res = Math.max(depth,res);
        }
        depth = depth+1;
        helper(root.left,depth);
        helper(root.right,depth);
    }

    /**
     * Answer
     */
    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int maxDepth3(TreeNode root){
        if (root == null) return 0;
        int l = maxDepth3(root.left)+1;
        int r = maxDepth3(root.right)+1;
        return Math.max(l,r);
    }

}
