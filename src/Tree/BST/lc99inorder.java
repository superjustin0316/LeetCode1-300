package Tree.BST;

import Tree.TreeNode;

public class lc99inorder {
    /**
     inorder 遍历
     */
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void lc99(TreeNode root){
        if (root == null) return;
        helper(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }

    public void helper(TreeNode root){
        if (root == null) return;
        helper(root.left);
        //主体
        if (prev != null && prev.val >= root.val){
            if(first == null) first =prev;
            second =root;
        }
        prev = root;
        //
        helper(root.right);
    }
}
