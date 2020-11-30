package BackTracking;

import LinkedList.ListNode;

public class linkedList21 {

    //O(n) O(n)
    public ListNode lc21_2(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = lc21_2(l1.next,l2);
            return l1;
        } else {
            l2.next =lc21_2(l1,l2.next);
            return l2;
        }
    }
}
