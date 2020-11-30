package Tree.PreorderAPP;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class  lc112_113 {

    /**
     先序遍历
     */
    public static boolean lc112(TreeNode root, int sum){
        if (root == null) return false;
        if ( root.left == null && root.right == null) return root.val== sum;
        return  lc112(root.left,sum -root.val) || lc112(root.right,sum -root.val);
    }

    public List<List<Integer>> lc113(TreeNode root,int sum){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res,new ArrayList<>(),root,sum);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> list,TreeNode root, int sum){
        if (root ==null) return;

        list.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == root.val){
                res.add(new ArrayList<>(list));
            }
        }
        helper(res,list,root.left,sum -root.val);
        helper(res,list,root.right,sum -root.val);
        list.remove(list.size()-1);//重点！！取消掉最后一个无效值
    }
}
