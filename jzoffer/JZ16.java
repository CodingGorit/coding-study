package cn.gorit.jzoffer;

import cn.gorit.datastructure.ListNode;

// 合并两个有序链表
public class JZ16 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode newNode = new ListNode(-1);
        ListNode res = newNode;
        // 不知道哪个链表长，哪个链表短
        while (list1!=null && list2 != null) {
            if (list1.val > list2.val) {
                newNode.next = list2;
                list2 = list2.next;
            } else {
                newNode.next = list1;
                list1 = list1.next;
            }
            newNode = newNode.next; // 自己本身切换
        }
        if (list1 == null)
            newNode.next = list2;
        else
            newNode.next = list1;
        return res.next;
    }
}
