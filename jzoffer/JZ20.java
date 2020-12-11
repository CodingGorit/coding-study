package cn.gorit.jzoffer;

import java.util.Stack;

/**
 * 包含 min 函数的栈
 * 一个可以返回最小值的栈（最小值的栈总是保证其栈顶元素的值最小）
 */
public class JZ20 {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minVal = new Stack<Integer>(); // 辅助栈

    public void push(int node) {
        stack.add(node);
        if (minVal.isEmpty()) {
            minVal.add(node);
        } else { // 不为空时，总是保证栈顶元素是最小的
            minVal.add(node < minVal.peek() ? node : minVal.peek());
        }
    }

    // 出栈才是 pop
    public void pop() {
        stack.pop();
        minVal.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minVal.peek();
    }
}
