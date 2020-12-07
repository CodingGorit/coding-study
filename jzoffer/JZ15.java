package cn.gorit.jzoffer;

import cn.gorit.datastructure.ListNode;

/**
 * 反转链表
 * 非递归方式：
 */
public class JZ15 {
    public ListNode ReverseList(ListNode head) {
        if (head==null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
