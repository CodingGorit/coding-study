package Algorithm.sort;

import java.util.Arrays;

// 选择排序
/**
 * 每次选择出一个最大或者最小的元素
 *  然后将它插入到最前面
 *
 *  时间复杂度 O(n^2)
 * */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {6,7,3,5,4,8};
        System.out.println("Before Sorting"+ Arrays.toString(arr));
        selectSort(arr);
        System.out.println("After Sorting"+ Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            int max = i; // 记录最大元素的下标
            System.out.println(Arrays.toString(arr));
            // 每次遍历找到最大元素的下标
            for (int j=i+1;j<arr.length;j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            // 比较当前的 i 和 max 是否相同，不相同就进行交换
            if (i != max) {
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
    }
}
