package leetcode.Node;

/**
 * leetcode  876
 * 寻找链表中间的节点（快慢指针经典的题目）
 * 快指针走完了，慢指针刚好走到中间
 */
public class MiddleNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast = head; // 快指针一次走两步
        ListNode low = head;// 慢指针一次走一步
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        // fast.nect 为 null  返回 low  对应奇数的情况，刚好返回中间值
        if (fast.next == null) {
            return low;
        }
        // fast.next.next = null  返回 low.next，对应偶数的情况，
        return low.next;
    }

}
