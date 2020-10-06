package Algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序：
 * 排序类型：交换排序，通过元素之间的比较和交换位置 来达到排序的目的
 * 排序思想：分治法
 * 排序方式：每一轮挑选一个基准元素，并让其他比它大的元素移动到数列另一边，比它小的元素移动到数列另一边，从而把数列拆解成两个部分
 * 时间复杂度分析：
 *  每一轮的比较和交换，需要把数组全部元素全部都遍历一遍，时间复杂度是 O(n)，这样遍历的一共需要多少轮呢？
 *  假如元素个数是 n，那么平均情况是 logn轮，快排的整体平均时间复杂度是 O(nlogn)
 *
 *  一、基准的选择：
 *      默认选取第一个元素
 *      1. 避免选择到最 (大) 小 值的情况，这是快排不希望看到的
 *      2. 默认是第一个元素，如果第一个元素是最大的，并且从大到小排列，那么完成快排需要使用 O(n^2)
 *         为了避免这种情况，随机选举一个元素作为基准元素，并且让基准元素和列首元素进行交换位置
 *      3. 即使随机选择，也有可能选择到最值的情况，也会影响到分治的效果
 *      快排的平均时间复杂度在 O(nlogn)，但是最坏情况在 O(n^2)
 *
 *  二、元素的交换
 *      选定基准后
 * */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {3,6,4,7,2,8,9,1,5};
        System.out.println("排序前"+ Arrays.toString(arr));
        quickSort1(arr,0,arr.length-1);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    // 双边循环法
    private static void quickSort(int [] arr, int l, int r) {
        // 递归结束条件，l >= r 时
        if (l<r) {
//            // 得到基准元素的位置
//            int index = partition(arr,l,r);
//            // 根据基准，分成两部分进行排序
//            quickSort(arr,l,index-1);
//            quickSort(arr,index+1,r);

            // 得到基准元素的位置
            int index = partition_simple(arr,l,r);
            // 根据基准，分成两部分进行排序
            quickSort(arr,l,index-1);
            quickSort(arr,index+1,r);
        }
    }

    /**
     * 分治（双边循环法） 实现元素的交换
     * l: 起始下标
     * r: 结束下标
     * 双边循环法从数组两边交替遍历元素
     * */
    private static int partition(int[] arr, int l, int r) {
        //取第一个位置 （也可以是随机位置） 的元素作为元素基准
        int privot = arr[l];
        int i = l; // 左
        int j = r;// 右

        while (i < j) {
            // 控制 j 指针比较并左移
            while (i<j && privot < arr[j])
                j--;
            // 控制 i 指针比较并向右移
            while (i<j && privot >= arr[i])
                i++;
            // 交换 i 和 j
            if (i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 基准点和指针重合点交换
        // 使基准左侧保持有序
        arr[l] = arr[i];
        arr[i] = privot;
        return i;
    }

    /**
     * 分治：（单边循环法）从数组一边对元素进行遍历和交换
     *  1. 选定基准元素 privot
     *  2. 设置 mark 指针，指向数组的起始位置，mark 指针代表小于基准区域的边界
     */
    private static int partition_simple(int[] arr, int l, int r) {
        // 取第1个位置（也可以是随机位置）的元素为基准元素
        int pivot = arr[l];
        int mark = l; // mark 指针代表小于基准元素的区域边界
        for (int i=l+1;i<=r;i++) {
            // 交换 mark 和小于基准的值
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        // 重合点交换位置
        arr[l] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 非递归方法实现快排
     * */
    private static void quickSort1(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String,Integer>> quickSortStack = new Stack<Map<String,Integer>>();
        // 整个数列的起止下标
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String,Integer> param = quickSortStack.pop();
            // 得到基准元素位置
            int pivotIndex = partition(arr,param.get("startIndex"),param.get("endIndex"));
            // 根据基准元素分为两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<String,Integer>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if(pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
            }
        }


}
