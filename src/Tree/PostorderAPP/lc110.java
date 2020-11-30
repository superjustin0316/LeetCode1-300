package Tree.PostorderAPP;

import Tree.TreeNode;

import java.util.Map;

public class lc110 {

    /**
     * 后序遍历
     */
    public boolean lc110(TreeNode root){
        if (root == null) return true;
        return helper(root)!= -1;
    }

    public int helper(TreeNode root){
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        /**
         * 当前结果：Math.abs(l-r)>1
         * 之前的结果传递：l = -1 / r = -1
         */
        if (l == -1 || r == -1 || Math.abs(l-r)>1){
            return  -1;
        }
        return Math.max(l,r)+1;
    }


}
