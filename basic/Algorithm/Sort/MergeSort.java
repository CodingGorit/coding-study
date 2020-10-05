package Algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

/**
 * 归并排序学习
 * 递归拆分每个数组，每次拆一半，重新组合进行排序
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = new int[] {3,1};
        int[] arr = new int[] {1,3,5,2,4,6,8,10};
//        System.out.println(arr.length/4);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int low,int high) {
        int mid = (high + low)/2;
        if (low < high) {
            // 处理左边
            mergeSort(arr, low, mid);
            // 处理右边
            mergeSort(arr, mid+1, high);
            // 归并
            merge(arr,low,mid,high);
        } else {
            return;
        }
    }

    // 合并的方法
    public static void merge(int[] arr,int low,int mid,int high) {
        // 用于存储归并后的临时数组。
        int[] temp = new int[high-low+1];
        // 记录第一个数组的开始位置，需要遍历的下标
        int i = low;
        // 记录第二个数组需要的遍历的下标
        int j=mid+1;
        // 用于记录临时数组中存放的小标
        int temp_index = 0;
        // 循环遍历两个数组, 取出小的数字，放入临时数组中
        while (i <= mid && j <= high) {
            // 第一个数组的数据更小
            if (arr[i] <= arr[j]) {
                // 把小的数据放入临时数组中
                temp[temp_index] = arr[i];
                // 让下标向后移一位
                i++;
            } else {
                temp[temp_index] = arr[j];
                j++;
            }
            temp_index++;
        }
        // 处理多余的数据, 上面排完毕之后，数组中还有多余的
        while (j<=high) {
            temp[temp_index] = arr[j];
            j++;
            temp_index++;
        }

        while (i<=mid) {
            temp[temp_index] = arr[i];
            i++;
            temp_index++;
        }
        // 把临时数组中的数据重新存入原数组
        for (int k=0;k<temp.length;k++) {
            arr[k+low] = temp[k];
        }
    }
}
