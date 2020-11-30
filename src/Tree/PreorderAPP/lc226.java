package Tree.PreorderAPP;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc226 {

    /**
     * DFS
     */
    public TreeNode dfs(TreeNode root){
        if (root == null) return root;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    /**
     * BFS
     */
    public TreeNode bfs(TreeNode root){
        if (root == null) return root;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }


}
