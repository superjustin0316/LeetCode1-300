package LinkedList;

public class lc206_92 {

    public ListNode lc206(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;

        }
        return pre;
    }

    public ListNode lc92(ListNode head,int m, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < m; i++) {
             cur = cur.next;
             pre = pre.next;
        }
        for (int i = 1; i < n - m; i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
