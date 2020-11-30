package LinkedList;

public class lc203_83_82 {
    /**
     *  是sorted array，所以才能直接比较相邻的两项
     */

    public ListNode lc83(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null ){
            if (cur.next.val == cur.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public  ListNode lc82(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        while (p.next != null && p.next.next != null){
            if (p.next.val == p.next.next.val){
                int samNum = p.next.val;
                while (p.next != null && p.next.val == samNum){
                    p.next = p.next.next;
                }
            }else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public ListNode lc203_1(ListNode head, int val){
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null){
            if (p.next.val == val){
                p.next=p.next.next;
            }else {
                p=p.next;
            }
        }
        return dummy.next;
    }

    public ListNode lc203_2(ListNode head, int val){
        if (head == null) return head;
        ListNode p = head;
        while (p.next != null){
            if (p.next.val == val){
                p.next=p.next.next;
            }else {
                p=p.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public ListNode lc203_3(ListNode head, int val){
        if (head == null) return head;
        head.next = lc203_3(head.next,val);
        return head.val == val ? head.next : head;
    }

}
