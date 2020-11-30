package Tree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc144Preorder {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /**
     * 递归方法：
     */
    public static List<Integer> lc144(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public static void helper(List<Integer> res, TreeNode root){
        if (root == null) return;

        res.add(root.val);
        helper(res, root.left);
        helper(res,root.right);
    }
    /**
     * stack方法
     */
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //stack先进后出
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            res.add(cur.val);
        }
        return res;
    }

}
