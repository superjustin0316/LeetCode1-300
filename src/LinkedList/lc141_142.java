package LinkedList;

import java.util.List;

public class lc141_142 {
    /**
     *    https://www.cnblogs.com/hiddenfox/p/3408931.html
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
      }
  }
    public static boolean lc141(ListNode head) {
        if (head == null || head.next == null) return false;//无节点/有一个节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null &&  fast.next.next != null) {//null意味着终点,防止有空指针异常
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode lc142(ListNode head){

        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode keyNode = head;
        while (fast != null && fast.next != null){// 空指针不存在next，不存在null.next
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                keyNode = head;
                while (slow != keyNode){
                    keyNode=keyNode.next;
                    slow = slow.next;
                }
                return keyNode;
            }
        }
        return null;
    }

}
