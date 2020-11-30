package Tree.BST;

import Tree.TreeNode;

public class lc230 {

    private static int count = 0;
    private static int res = 0;

    public int lc230(TreeNode root, int k){
        count = k;
        helper(root);
        return res;
    }

    public static void helper(TreeNode root){
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
