package Tree.LevelorderAPP;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc103_107 {

    /**
     * levelOrder  107
     */
    public List<List<Integer>> lc107(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <size; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(0,list);
        }
        return res;
    }

    public static List<List<Integer>> lc107_1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root,0);
        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root,int level){
        if (root == null) return;;
        if (level >= res.size()){
            res.add(0,new ArrayList<>());//在list的头部加入
        }
        res.get(res.size() - level - 1).add(root.val);
        helper(res,root.left,level+1);
        helper(res,root.right,level+1);
    }

    /**
     * levelOrder  103
     */
    public List<List<Integer>> lc103(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean x = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //level by level
            for (int i = 0; i < size; i++) {
                 TreeNode cur = queue.poll();
                 if (x){
                     list.add(cur.val);
                 }else {
                     list.add(0,cur.val);
                 }
                 if (cur.left != null)  queue.offer(cur.left);
                 if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
            x = !x;
        }
        return res;
    }


}
