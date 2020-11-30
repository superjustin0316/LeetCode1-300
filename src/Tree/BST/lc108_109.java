package Tree.BST;

import LinkedList.ListNode;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc108_109 {
    /**
     本质是找中点位置的元素
     */
    //O(n)  O(n)
    public static TreeNode lc108(int[] nums){
        if (nums == null || nums.length == 0) return  null;
        return helper(nums,0,nums.length-1);

    }
    public static TreeNode helper(int[] nums,int left, int right){
        if (left > right) return null;
        int mid =(right - left)/2+left;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums,left,mid-1);
        node.right = helper(nums,mid+1,right);
        return node;
    }

    public TreeNode lc109(ListNode head){
        if (head == null) return null;
        return toBST(head,null);
    }

    public TreeNode toBST(ListNode head, ListNode tail){
        if (head == tail) return  null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
    }

    public static List<List<Integer>> leverlOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                 TreeNode cur = queue.poll();
                 if (cur.left != null) queue.add(cur.left);
                 if (cur.right != null) queue.add(cur.right);

                 list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6};
        TreeNode root = lc108(nums);
        List<List<Integer>> res = leverlOrder(root);

        for (List<Integer> list :res){
            System.out.println(list);
            System.out.println();
        }
    }
}
