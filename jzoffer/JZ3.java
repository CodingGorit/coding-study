package cn.gorit.jzoffer;

import cn.gorit.datastructure.ListNode;

import java.util.ArrayList;

/**
 * 剑指 offer 从尾到头打印链表
 */
public class JZ3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode pre = null;
        ListNode curr = listNode;
        while (curr!=null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
}
