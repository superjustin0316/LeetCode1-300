package Tree.LevelorderAPP;

import Tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc199 {
    /**
     DFS
     */
    public List<Integer> lc199_1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root,0);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root, int level){
        if (root == null) return;
        if (res.size() == level){
            res.add(root.val);
        }
        helper(res,root.right,level+1);
        helper(res,root.left,level+1);
    }
    /**
     BFS
     */
    public List<Integer> lc199_2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                if (i==size-1) res.add(cur.val);
            }
        }
        return res;
    }


}
