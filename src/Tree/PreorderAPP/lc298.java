package Tree.PreorderAPP;

import Tree.TreeNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class lc298 {
    //O(n) O(n)
    private int res = 0;
    public int lc298(TreeNode root){
        if (root == null) return 0;
        helper(root,0,root.val);
        return res;
    }

    private void helper(TreeNode root, int max , int target){
        if (root== null) return;
        if (root.val == target){
            max++;
        } else max =1;
        res = Math.max(res, max);
        helper(root.left,max,root.val +1);
        helper(root.right,max,root.val+1);
    }
}
