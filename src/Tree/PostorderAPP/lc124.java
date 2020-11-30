package Tree.PostorderAPP;

import Tree.TreeNode;

public class lc124 {
    /**
     * O(n) O(n)
     */
    int res;
    public int lc124(TreeNode root){
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return  res;
    }

    public int helper(TreeNode root){
        if (root == null) return  0;
        //对负节点的处理：
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        int sum = left+right+root.val;
        res = Math.max(res,sum);

        return Math.max(left,right) + root.val;
    }
}
