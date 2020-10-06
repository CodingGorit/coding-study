package Algorithm.sort;

import Array.util.MyQueue;

import java.util.Arrays;

// 基数排序
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[] {23,6,189,45,9,287,56,1,791,34,65,652,6};
        System.out.println(Arrays.toString(arr));
        redix_queue_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 基数排序简单
    public static void radixSort(int[] arr) {
        // 存数组中最大的数字
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 计算最大数字是几位数, 将其转换成字符串，然后求其长度
        int maxLength = (max+"").length();
        // 用于临时存储数据的数组
        int[][] temp = new int[10][arr.length];
        // 用于记录在 temp 数组中相应数组中存放的数字的数量
        int[] counts = new int[10];
        // 根据最大长度的数决定比较的次数
        for (int i=0,n=1;i<maxLength;i++,n*=10) {
            // 分别取出每个数字的个位，十位，百位（个位 %10  十位 /10%10 百位 /100%10）

            // 把每一个数字分别计算余数
            for (int j=0;j<arr.length;j++) {
                // 计算余数
                int mol = arr[j]/n%10;
                // 把当前遍历的数字放到指定的数组中
                temp[mol][counts[mol]] = arr[j];
                // 记录数量
                counts[mol]++;
            }
            // 记录取的元素需要放的位置
            int index = 0;
            // 把数字取出来
            for (int k=0;k<counts.length;k++) {
                // 记录数量的数组中当前余数的数量不为0
                if (counts[k]!=0)  {
                    // 循环取出元素
                    for (int l=0;l<counts[k];l++) {
                        // 取出元素
                        arr[index++] = temp[k][l];
                    }
                    // 把数组置为0
                    counts[k] = 0;
                }
            }
        }
    }

    // 基数排序优化（队列实现基数排序），使用队列不需要计数
    public static void redix_queue_sort(int[] arr) {
        // 存数组中最大的数字
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 计算最大数字是几位数, 将其转换成字符串，然后求其长度
        int maxLength = (max+"").length();
        // 用于临时存储数据的队列数组,创建十个队列
        MyQueue[] temp = new MyQueue[10];
        // 为队列数组赋值
        for (int i=0;i<temp.length;i++) {
            temp[i] = new MyQueue();
        }
        // 根据最大长度的数决定比较的次数
        for (int i=0,n=1;i<maxLength;i++,n*=10) {
            // 分别取出每个数字的个位，十位，百位（个位 %10  十位 /10%10 百位 /100%10）

            // 把每一个数字分别计算余数
            for (int value : arr) {
                // 计算余数
                int mol = value / n % 10;
                // 把当前遍历的数字放到指定的队列中
                temp[mol].add(value);
            }
            // 记录取的元素需要放的位置
            int index = 0;
            // 把所有队列中的所有数字取出来
            for (MyQueue myQueue : temp) {
                // 记录的队列不为空
                // 循环取出元素
                while (!myQueue.isEmpty()) {
                    // 取出元素
                    arr[index] = myQueue.pull();
                    // 记录下一个位置
                    index++;
                }
            }
        }
    }
}
