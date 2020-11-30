package BackTracking;

import LinkedList.ListNode;

public class linkedList203 {
    public ListNode lc203_3(ListNode head, int val){
        if (head == null) return head;
        head.next = lc203_3(head.next,val);
        return head.val == val ? head.next : head;
    }
}
