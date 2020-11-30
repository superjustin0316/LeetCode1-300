package Tree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc94Inorder {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    /**
     * 递归方法
     */
    public static List<Integer> lc94(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root);
        return res;
    }

    public static void helper(List<Integer> res, TreeNode root){
        if (root == null) return;
        helper(res,root.left);
        res.add(root.val);
        helper(res,root.right);
    }

    /**
     * stack方法
     */
    public static List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
