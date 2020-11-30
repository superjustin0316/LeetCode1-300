package Tree.PreorderAPP;

import Tree.TreeNode;

public class lc101 {

    public boolean isSymmetricTree(TreeNode root){
        if (root == null) return true;
        return  helper(root.left,root.right);

    }

    public boolean  helper(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        //否定
        if (a.val != b.val)  return false;
        return  helper(a.left,b.right) &&  helper(a.right,b.left);
    }
}
