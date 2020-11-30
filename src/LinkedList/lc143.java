package LinkedList;

public class lc143 {


    public void lc143(ListNode head){
        if (head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode l1 = head, l2 = head;

        /**
         * 找中点：
         * slow 奇数-->中间点，偶数-->后一半的第一个元素
         * temp 奇数-->中间点的前一个点，偶数-->前一半的最后一个元素
         */
        ListNode temp = null;
        ListNode slow = head, fast= head;
        while (fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode l3 = reverse(slow);
        merge(l1,l3);//??
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2){
        while (l1 != l2){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;

            l1.next = l2;
            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
    }

}
