package Array.util;

/**
 * 实现栈，使用数组存储数据
 * 每次往栈顶添加元素
 * */
public class MyStack {
    int[] elements;

    public MyStack() {
        elements = new int[0];
    }
    // 入栈 push， 把数据放进栈的最后
    public void push(int element) {
        int newArr[] = new int[elements.length+1];

        for (int i=0;i<elements.length-1;i++) {
            newArr[i] = elements[i];
        }
        //
        newArr[elements.length] = element;
        // 更新数组
        elements = newArr;
    }

    // 出栈 pop， 取栈顶元素
    public int pop() {
        if (elements.length == 0) {
            throw new RuntimeException("tack is empty!");
        }

        // 去最后一个元素
        int element = elements[elements.length-1];
        // 创建一个新数组
        int newArr[] = new int[elements.length-1];
        for (int i=0;i<elements.length-1;i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        // 返回栈顶元素
        return element;
    }

    //查看栈顶元素
    public int peek() {
        if (elements.length == 0) {
            throw new RuntimeException("tack is empty!");
        }
        return elements[elements.length-1];
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return elements.length == 0;
    }
}
