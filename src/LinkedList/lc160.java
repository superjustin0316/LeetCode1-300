package LinkedList;

public class lc160 {

    //O(n) O(1)
    public ListNode lc160(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB){
            while (lenA != lenB){
                headA = headA.next;
                lenA--;
            }
        }else {
            while (lenA != lenB){
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode head){
        int len = 1;
        while (head != null){
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode lc160_2(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return  null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
