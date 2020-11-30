package LinkedList;

public class lc234 {

    /**
     * 方法：新旧两个数组对照
     * 题目要求space O(1)  -->  不能开辟新的空间
     * @param head
     * @return
     */

    public boolean lc234(ListNode head){
        if (head == null) return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);//?

        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null){
            if (p.val != q.val){
                p = p.next;
                q = q.next;
            }
        }
        return  true;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;//return 结尾的节点
    }
}
