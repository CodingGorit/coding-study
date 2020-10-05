package Algorithm.sort;

import java.util.Arrays;
/**
 * 冒泡排序：
 * 排序类型：交换排序，通过元素之间的比较和交换位置 来达到排序的目的
 * 排序方式：
 *  冒泡排序在每一轮中只把1个元素冒泡到数列的一端
 *  每个元素都可以像一个小气泡一样，根据自身大小，一点一点向数组一侧移动。算法的每一轮都是从左到右比较元素，进行单向位置交换。
 *
 * 算法稳定性：
 *  冒泡排序是一种稳定排序，值相等的元素不会打乱原本的顺序。
 *
 *  时间复杂度：O(n^2)
 *   该排序算法每一轮都要遍历所有元素，总共遍历（元素数量 - 1）轮，所以平均时间复杂度是 O(n^2)
 * */
public class BoubleSort {

    public static void main(String[] args) {
        // 测试数组一： {2,1,3,7,5,8,6}
        int [] arr = new int[] {3,2,1,4,5,6,7,8};
        // 适合 boubleSort2 的数组  {3,2,1,4,5,6,7,8}  适合后半部分有序的数组
        System.out.println("Before Sort 排序前");
        print(arr);
        System.out.println("Sorted 排序后");
        boubleSort3(arr);
        print(arr);
    }

    public static void boubleSort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

//    升级版本
    public static void boubleSort1(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            boolean flag = true;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    // 有元素进行交换，所以不是有序的，标记变为 false
                    flag = false;
                }
            }
            System.out.println("第"+(i+1)+"趟"+ Arrays.toString(arr));
            if (flag) // 有序则跳过大循环
                break;
        }
    }

    /**
     * 错误算法：无法实现排序
     * 对数列有序的界定
     * 标识出最后一次元素交换的位置，该位置即为无序梳理的边界，再往后就是有序区了。
     * */
    public static void boubleSort2(int[] arr) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比较到这里位置
        int sortBorder = arr.length-1;
        for (int i=0;i<arr.length-1;i++) {
            boolean isSort = true;
            for (int j=i+1;j<sortBorder;j++) {
                int temp = 0;
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 因为有元素交换，所以不是有序的，标记变为 false。
                    isSort = false;
                    // 更新未最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSort)
                break;
        }
    }

    /**
     * 鸡尾酒排序：来回钟摆排序
     * 第一轮：从左往右交换排序
     * 第二轮：从右边往左边交换排序
     * 第三轮：从左边往右边交换排序
     * 。。。。
     *
     * 优点：
     *  1. 在特定条件下，减少排序的回合数
     *  2. 缺点，代码量增加了一倍 （分开进行排序）
     *
     *  场景：
     *  大部分元素已经有序的情况
     * */
    public static void boubleSort3(int[] arr) {
        int temp = 0;
        for (int i=0;i<arr.length/2;i++) {
            // 有序标记, 每一轮的初始值的 true
            boolean isSorted = true;
            // 奇数轮，从左往右边比较和交换元素
            for (int j=i;j<arr.length-i-1;j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 有元素交换，所以不是有序的，标记变为 false
                    isSorted = false;
                }
            }
            if (isSorted)
                break;

            // 在偶数轮之前，将 isSorted 重新标记为 true
            isSorted = true;
            // 偶数轮，从右边往左边比较和交换元素
            for (int j=arr.length-i-1;j>i;j--) {
                if (arr[j] < arr[j-1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
    }

    // print each element in the array
    public static void print(int [] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
