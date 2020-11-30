package LinkedList;

public class lc19 {

    public ListNode lc19(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next=head;
        for (int i = 0; i <= n; i++) {
        //for (int i = 0; i<n; i++)
             fast = fast.next;
        }
        while (fast != null){
        //while (fast.next != null)
            fast = fast.next;
            slow = slow.next;
        }//fast 到达末尾的时候，slow的后面一个位置就是删除位置
        slow.next = slow.next.next;
        System.out.println("slow.next="+slow.next.val);
        return dummy.next;
    }

}
