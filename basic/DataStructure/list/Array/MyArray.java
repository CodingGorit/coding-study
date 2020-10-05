package Array.util;

import java.util.Arrays;

public class MyArray {
    private int[] elements;// 存储数据的数组，如果存储其他类型，声明为 Object

    public MyArray() {
        elements=new int[0];
    }

    public int size() {
        return elements.length;
    }

    // 往数组添加元素 （数组拷贝问题）
    public void add(int element) {
        int[] newArr = new int[elements.length+1];

        // 把原数组的元素复制到新数组中
        for (int i=0;i<elements.length; i++) {
            newArr[i] = elements[i];
        }

        // 在把添加的元素添加到元素末尾
        newArr[elements.length] = element;

        // 新数组替换旧数组
        elements=newArr;
    }

    // 打印所有元素
    public void show() {
        System.out.println(Arrays.toString(elements));
    }

    // 删除数组中的元素
    public void delete(int index) {
        // 判断下标是否越界
        if (index<0 || index>elements.length-1) {
            throw new RuntimeException("下标越界");
        }

        int[] newArr = new int[elements.length-1];
        // 复制原有数据到新数组
        for (int i=0; i<newArr.length; i++) {
            if (i<index) {
                newArr[i] = elements[i];
            } else {
                // 想要删除之后的元素
                newArr[i] = elements[i+1];
            }
        }
        // 新数组替换就数组
        elements = newArr;
    }

    public int get(int index) {
        if (index<0 || index >elements.length)
            throw new RuntimeException("下标越界");
        return elements[index];
    }

    // 插入元素到一个指定位置
    public void insert(int index, int element) {
        // 创建一个新数组
        int[] newArr = new int[elements.length + 1];

        for (int i=0;i<newArr.length;i++) {
            // 前面的数据保持一致
            if (i<index) {
                newArr[i] = elements[i];
            } else {
                // 后面的数据在插入的位置留出来
                newArr[i+1] = elements[i];
            }
        }
        // 实现插入操作
        newArr[index] = element;
        // 数组替换
        elements = newArr;
    }

    // 替换指定位置的元素
    public void set(int index, int element) {
        elements[index] = element;
    }

    // 线性查找
    public int search(int target) {
        int index = -1;
        for (int i=0;i<elements.length;i++) {
            if (elements[i] == target) {
                index = i;
                break;
            }
        }
        return index; // 没有找到返回 -1
    }

    // 二分法查找
    public int BinarySearch(int target) {
        // 查找起始位置
        int begin = 0;
        // 查找结束位置
        int end = elements.length - 1;
        // 查找的中间位置
        int mid = (begin + end)/2;

        // 不知道具体要查找多少次
        while (true) {
            // 找不到的情况
            if (begin>=end) {
                return -1;
            }

            // 找到的情况
            if (elements[mid] == target) {
                return mid;
            } else {
                // 说明数据在左边
                if (elements[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
                mid = (begin + end)/2;
            }
        }
    }


}
