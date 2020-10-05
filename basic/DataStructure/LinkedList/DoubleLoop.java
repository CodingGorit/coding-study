package Array.util;

// 双向链表实现
public class DoubleLoop {
    // 上一个节点
    private DoubleLoop pre;
    // 下一个节点
    private DoubleLoop next = this;
    // 节点的数据
    private int data;

    public DoubleLoop(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    // 增加节点
    public void after(DoubleLoop node) {
        // 原来的下一个节点
        DoubleLoop nextNext = next;
        // 新节点作为当前节点的下一个节点
        this.next = node;
        // 当前节点作为新节点的前一个节点
        node.pre = this;
        // 原来的下一个节点作为新节点的下一个节点
        node.next = nextNext;
        // 让原来的下一个节点的上一个节点为当前新节点
        nextNext.pre = node;
    }

    // 下一个节点
    public DoubleLoop next() {
        return this.next;
    }

    // 上一个节点
    public DoubleLoop pre() {
        return this.pre;
    }
}
