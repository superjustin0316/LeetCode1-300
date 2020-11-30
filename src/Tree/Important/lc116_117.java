package Tree.Important;

import Tree.TreeNode;

public class lc116_117 {

    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     针对于满二叉树 perfect binary tree
     */
    //DFS --> recursion  O(n)O(n)
    public Node lc116_1(Node root){
        if (root == null) return null;
        if (root.left != null){
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null){
            root.right.next = root.next.left;
        }
        lc116_1(root.left);
        lc116_1(root.right);
        return root;
    }
    //BFS --> 迭代  O(n)  O(1)
    public Node lc116_2(Node root){
        Node start = root;
        while (start != null){
            Node cur = start;
            while (cur != null){
                if (cur.left != null){
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return start;
    }

    /**
     不是满二叉树 ---> 实现题目 分情况讨论
     1.A.left --> A.right
     2.A.right --> B.left
     3.
     */
    public void lc117(Node root){
        Node cur = root;
        Node head = null;// level start
        Node pre = null;

        while (cur != null){
            while (cur != null){
                if (cur.left != null){
                    if (pre != null){
                        pre.next = cur.left;
                    }else head = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null){
                    if (pre != null){
                        pre.next = cur.right;
                    }else head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
        }
    }
}
