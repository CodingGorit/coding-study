package cn.gorit.jzoffer;

import java.util.Stack;

/**
 * 栈的亚茹，弹出序列
 * 根据栈的先进后出的特点，后进的元素。出栈的几率越大
 */
public class JZ21 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)  return false;
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i=0;i<pushA.length;i++) {
            stack.push(pushA[i]);
            // 当栈顶元素等于数组 B时，就出栈，循环结束，判断栈是否为空，空就是 true
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
