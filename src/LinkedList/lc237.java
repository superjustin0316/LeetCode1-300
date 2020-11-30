package LinkedList;

public class lc237 {

    //O(1) O(1)
    public void lc237(ListNode node){
        if (node == null) return;;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
