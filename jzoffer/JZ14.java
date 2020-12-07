package cn.gorit.jzoffer;

import cn.gorit.datastructure.ListNode;

/**
 * 链表中倒数第 k 个节点
 */
public class JZ14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (k--!=0) { // 当 k 大于链表长度了，返回 null
            if (fast!=null)
                fast = fast.next;
            else
                return null;
        }

        while (fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
