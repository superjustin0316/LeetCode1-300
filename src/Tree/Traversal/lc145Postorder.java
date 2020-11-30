package Tree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc145Postorder {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public static List<Integer> lc145( TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null)  return  res;
        helper(res,root);
        return res;
    }

    public static void helper(List<Integer> res,  TreeNode root){
        if (root == null) return;
        helper(res,root.left);
        helper(res,root.right);
        res.add(root.val);
    }

    public static List<Integer> postorder( TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack< TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
