package LinkedList;

public class lc24 {

    public ListNode lc24(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);//定义一个节点值为0的空节点
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null){
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;

            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}

/**
 *
 * ListNode list=new ListNode() 初始化一个空节点，无值,不提倡此种写法。
 * ListNode list=new ListNode(0) 初始化一个节点值为0的空节点，最常用最正规写法
 * ListNode list=null 为空，什么都没有，一般不这么写；
 *
 */
