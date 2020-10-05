package Algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *  缩小增量排序
 *  执行思路：把数组的元素按下表增量分组，对每一组元素进行插入排序，缩小增量并重复之前的步骤
 *  稳定性：不稳定的排序算法
 *  为什么提高了效率：元素依次移动可能跨国多个元素，从而抵消了多次移动，提高效率。
 *  和普通插入排序的区别在哪里： 普通插入排序就是增量为 1 的希尔排序，跨元素的希尔排序只改变了增量，逻辑上和插入排序没有任何区别
 * 时间复杂度： 优于 O(n^2)  比不上 O(nlogn) 在 O(n^1.3) ~ O(n^2) 之间
 * 适用规模，中等范围的规模的数据
 * */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,6,4,7,2,8,9,1,5};
        System.out.println("排序前"+ Arrays.toString(arr));
        shellSort_advance(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int step = arr.length/2; // 初始化增量为数组的一半
        while(step>0) { // 增量必须是大于0的整数
            // 使用一层 for 循环，每遍历到一个数，就对它所在的数组进行插入排序，这样遍历，同样符合插入排序的要求
            for (int i=step;i<arr.length;i++) {
                while (arr[i] < arr[i -step]) { // 对每组进行插入排序
                    int temp = arr[i];
                    arr[i] = arr[i -step];
                    arr[i -step] = temp;
                }
            }
            step/=2; // 增量缩小一半
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void shellSort_advance(int[] arr) {
        // 改进
        int step = 1; // 定义增量为数组长 1 4 13 40
        while (step < arr.length) {
            step = step*3+1;
        }

        while (step>0) {
            for (int i=step;i<arr.length;i++) {
                int temp = arr[i];
                int j = i - step;
//                System.out.println("j:"+j+" "+"step:"+step);
                while (j>=0 && arr[j] > temp ) {
                    System.out.println(arr[j+step] + " "+ arr[j]);
                    arr[j+step] = arr[j];
                    j-=step;
                }
                arr[j+step] = temp;
            }
            step=(int)Math.floor(step/3);
            System.out.println(Arrays.toString(arr));
        }
    }
}
