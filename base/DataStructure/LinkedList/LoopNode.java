package Array.util;

// 循环链表
// 一个节点
public class LoopNode {
    // 节点内容
    private int data;
    // 下一个节点
    private LoopNode next = this;
    public LoopNode(int data) {
        this.data = data;
    }


    // 获取下一个节点的方法
    public LoopNode next() {
        return this.next;
    }

    // 获取节点中的数据
    public int getData() {
        return this.data;
    }

    // 插入一个节点，作为当前节点的下一个节点
    public void after(LoopNode node) {
        // 取出下一个节点，作为下下一个节点
        LoopNode nextNext = next;
        // 把新节点插入为当前节点的下一个节点
        this.next = node;
        // 把下下一个节点作为新节点的下一个节点
        node.next = nextNext;
    }

    // 删除下一个节点
    public void removeNext() {
        // 取出下下一个节点
        LoopNode newNext = next.next;
        // 把下下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }

    // 显示所有节点的信息
    public void show() {
        LoopNode currentNode = this;
        while (true) {
            System.out.print(currentNode.data+" ");
            // 取出下一个节点
            currentNode = currentNode.next;
            // 如果是最后一个节点
            if (currentNode == null) {
                System.out.println();
                break;
            }
        }
    }

}
