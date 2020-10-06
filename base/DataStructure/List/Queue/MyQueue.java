package Array.util;
/**
 * @author Gorit
 * @date 2020年3月28日15:09:21
 * 队列：
 * 先进先出，后进后出
 * */
public class MyQueue {
    private int[] elements;

    // 使用构造方法初始化数组
    public MyQueue() {
        this.elements = new int[0];
    }

    // 入队
    public void add(int element) {
        int[] newArr = new int[elements.length + 1];
        // 数组拷贝
        System.arraycopy(elements, 0, newArr, 0, elements.length);
        newArr[elements.length] = element;
        this.elements = newArr;
    }

    // 出队
    public int pull() {
        int element = elements[0]; // 取出第一个数
        int[] newArr = new int[elements.length-1];
        // 这里使用新数组的长度来拷贝
        for (int i=0;i<newArr.length;i++) {
            newArr[i] = elements[i+1];
        }
        this.elements = newArr;
        return element;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return this.elements.length == 0;
    }
}
