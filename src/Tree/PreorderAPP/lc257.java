package Tree.PreorderAPP;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc257 {
    /**
     * 本质上是preorder
     */
    public List<String> lc257(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,root,"");
        return res;
    }

    private void helper(List<String> res, TreeNode node,String path){
        if (node.left == null && node.right == null) {
            res.add(path+ node.val);
            return;
        }
        if (node.left != null) helper(res,node.left,path +node.val+"->");
        if (node.right != null) helper(res,node.right,path +node.val+"->");
    }

    /**
     * My Solution
     */

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) return res;
            String path = "";

            helper(res,root,path);
            return res;

        }
        private void helper(List<String> res, TreeNode node,String path){
            if (node.left == null && node.right == null) {
                path = path +node.val;
                res.add(path);
                return;
            }
            path = path+node.val;

            if (node.left != null) helper(res,node.left,path+"->");
            if (node.right != null) helper(res,node.right,path+"->");
        }
    }


}
