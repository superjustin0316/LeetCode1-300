package Tree.PreorderAPP;

import Tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class lc129 {

    public int lc129(TreeNode root){
        return helper(root,0);
    }

    public int helper(TreeNode root, int num){
        if (root == null) return 0;
        if (root.left != null && root.right != null){
            return num*10+root.val;
        }
        return helper(root.left,num*10+root.val)+helper(root.right, num*10+root.val);
    }
    /**
     My Solution
     */
    class Solution {
        public int sumNumbers(TreeNode root) {
            ArrayList<Integer> array = new ArrayList<>();
            int sum =0;
            helper(root,0,array);
            for (Integer i : array) {
                sum += i;
            }
            return sum;
        }

        public void helper(TreeNode root,int num, ArrayList<Integer> array){
            if (root == null) return;
            if (root.left == null && root.right == null){
                num = 10 * num +root.val;
                array.add(num);
                return;
            }
            num = 10*num+root.val;
            helper(root.left,num,array);
            helper(root.right,num,array);
            num = num /10;//回溯时 还原数据
        }
    }
}
