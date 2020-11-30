package LinkedList;

public class lc2 {

    public ListNode lc2(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null){
            if (p1 != null){
                sum = sum + p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                sum = sum + p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum%10);
            sum = sum / 10;
            cur = cur.next;
        }
        if (sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;

    }
}
