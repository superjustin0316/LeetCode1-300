package Tree.BST;

import Tree.TreeNode;

import java.util.Stack;

public class lc173 {

    private TreeNode cur;
    private Stack<TreeNode> stack;

    public lc173(TreeNode root){
        cur = root;
        stack = new Stack<>();
    }

    public boolean hasNext(){
        if (!stack.isEmpty() || cur != null){
            return true;
        }
        return false;
    }

    /**
     本质是中序遍历的迭代形式
     */
    private int next(){
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
