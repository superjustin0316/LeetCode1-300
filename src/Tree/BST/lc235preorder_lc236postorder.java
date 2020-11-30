package Tree.BST;

import Tree.TreeNode;

public class lc235preorder_lc236postorder {


    public TreeNode lc235(TreeNode root, TreeNode p, TreeNode q){
        if (root.val > p.val && root.val > q.val)  {
            return lc235(root.left,p,q);
        } else if (root.val < p.val && root.val <q.val){
            return lc235(root.right,p,q);
        } else {
            return root;
        }
    }


    public TreeNode lc236(TreeNode root, TreeNode p, TreeNode q){

        if (root == null || root == p || root == q) return root;

        TreeNode left = lc236(root.left, p, q);
        TreeNode right = lc236(root.right, p, q);

        if (left != null && right != null){
            return root;
        } else if (left != null && right == null){
            return left;
        } else if (left == null && right != null){
            return right;
        }else {
            return null;
        }

        //       等价写法：
//        if (left != null && right != null){
//            return root;
//        }
//        return left == null ? right : left;

    }
}
