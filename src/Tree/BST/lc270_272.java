package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class lc270_272 {

    /**
     My Solution
     */
    public int lc270_1(TreeNode root, double target){
        int res = root.val;
        double error = Integer.MAX_VALUE;
        while (root != null){
            if (error > Math.abs(root.val - target)){
                res= root.val;
                error = Math.abs(root.val - target);
            }
            if (root.val < target){
                root = root.right;
            } else if (root.val > target){
                root = root.right;
            } else {
                return root.val;
            }
        }
        return res;
    }

    /**
     Answer
     */
    public int lc270_2(TreeNode root, double target){
        int res = root.val;
        while (root != null){
            if (Math.abs(target - root.val) < Math.abs(target -res)){
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return  res;
    }

    /**
     My Solution
     */
    public List<Integer> lc272(TreeNode root, double target, int k){
        List<Integer> res = new ArrayList<>();
        HashMap<Double,Integer> map = new HashMap<>();
        helper(map,root,target,k);
        for (Double key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
    private void helper(HashMap<Double,Integer> map,TreeNode root, double target, int k){
        if (root == null) return;
        if (Math.abs(target - root.val)< getMaxError(map)){
                addError(map,k,target,root);
        }
        helper(map,root.left,target,k);
        helper(map,root.right,target,k);
    }
    public double getMaxError(HashMap<Double,Integer> map){
        if (map == null) return Integer.MAX_VALUE;
        double res = Integer.MIN_VALUE;
        for (Double key : map.keySet()){
            res = Math.max(res,key);
        }
        return res;
    }
    public void addError(HashMap<Double,Integer> map,int k,double target,TreeNode root){
        if (map.size() < k){
            map.put(root.val - target,root.val);
        }else {
            map.remove(getMaxError(map));
            map.put(root.val - target,root.val);
        }
    }

    /**
     Answer
     中序遍历是个递增的序列
     */
    //O(n) O(n)
    //中序遍历
    public List<Integer> lc272_1(TreeNode root, double target, int k){
        LinkedList<Integer> res = new LinkedList<>();
        helper(res,root,target,k);
        return res;
    }
    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k){
        if (res == null) return;
        helper(res,root.left,target,k);
        //主体
        if (res.size() == k){
            if (Math.abs(target - root.val) < Math.abs(target -res.peekFirst())){
                res.removeFirst();
            } else return;
        }
        res.add(root.val);
        //
        helper(res,root.right,target,k);
    }

    /**

     */
}
