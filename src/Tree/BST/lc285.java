package Tree.BST;

import Tree.TreeNode;

public class lc285 {

    /**
     * Inorder 找后继节点
     */
    public TreeNode lc285(TreeNode root, TreeNode p){
        TreeNode res = null;
        while (root != null){
            if (root.val < p.val){
                root = root.right;
            }else if (root.val > p.val){
                res = root;
                root =root.left;
            }else {
                root =root.right;
            }
        }
        res = res.left;
        return res;
    }
}
