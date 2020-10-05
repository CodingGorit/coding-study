package Array.util;

// 双链表
public class DoubleNode {
    private DoubleNode pre; // 前驱
    private int data; // 存储数据
    private DoubleNode next = this; // 下一个节点

    public DoubleNode(int data) {
        this.data = data;
    }

    // 获取上一个节点
    public DoubleNode pre() {
        return pre;
    }
    // 获取下一个节点
    public DoubleNode next() {
        return next;
    }

    // 增加节点
    public void append(DoubleNode node) {
        // 原来的下一个节点
        DoubleNode nextNode = next;
        // 新节点作为当前节点的下一个节点
        this.next = node;
        // 当前节点作为新节点的前一个节点
        node.pre = this;
        // 原来的下一个节点作为新节点的下一个节点
        node.next = nextNode;
        // 让原来的下一个节点的上一个节点为当前新节点
         nextNode.pre = node;
    }

    // 获取节点数据
    public int getData() {
        return this.data;
    }
}
