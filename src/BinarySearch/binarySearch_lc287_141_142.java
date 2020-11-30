package BinarySearch;

public class binarySearch_lc287_141_142 {

    // nlogn 1
    public int binarySearch_lc287_141_142(int[] nums){
        int min = 0;
        int max = nums.length -1;
        while (min <= max){
            int mid = (max - min) /2 + min;
            int count = 0 ;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid){
                    count++;
                }
            }
            if (count > mid){
                max = mid -1 ;
            } else {
                min = mid +1;
            }
        }
        return min;
    }

    //?????
    //  n  1
    public int solution2(int[] nums){
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 141,142
     *    https://www.cnblogs.com/hiddenfox/p/3408931.html
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean lc141(ListNode head) {
        if (head == null || head.next == null) return false;//无节点/有一个节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null &&  fast.next.next != null) {//null意味着终点,防止有空指针异常
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode lc142(ListNode head){

        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode keyNode = head;
        while (fast != null && fast.next != null){// 空指针不存在next，不存在null.next
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                keyNode = head;
                while (slow != keyNode){
                    keyNode=keyNode.next;
                    slow = slow.next;
                }
                return keyNode;
            }
        }
        return null;
    }


}
