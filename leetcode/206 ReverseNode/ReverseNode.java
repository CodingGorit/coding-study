package leetcode.Node;


/**
 * leetcode 206  反转链表
 */
public class ReverseNode {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    // 递归实现链表反转
    public ListNode reverListNode(ListNode head) {
        if (head == null) return  null;
        if (head.next == null) return  null;
        ListNode next = head.next;
        ListNode newNode =  reverListNode(next);
        next.next = head;
        head.next = null;
        return newNode;
    }

    // 正常循环实现链表反转
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 前驱节点
        ListNode current = head; // 保存当前节点
        while (current != null) {
            ListNode next = current.next; // 保存下一个节点
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
