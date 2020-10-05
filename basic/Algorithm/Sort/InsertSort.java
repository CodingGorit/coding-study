package Algorithm.sort;

import java.util.Arrays;

// 插入排序学习
/**
 *  插入排序
 *  稳定性：稳定的
 * 适用范围：基本有序，小规模数据
 * 时间复杂度：O(n^2)
 * */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = new int[] {3,6,4,7,2,8,9,1,5};
//        int[] arr = new int[] {3,1,2,5,4};
        int[] arr = {6,7,3,5,4,8};
        System.out.println("排序前");
        insertSort2(arr);
        System.out.println("排序后");
    }

    //    一步到位
    private static void insertSort1(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int temp = arr[i];
            System.out.println(Arrays.toString(arr));
            // 暴力枚举进行交换排序
            for (int j=i-1;j>=0&&arr[j]>temp;j--) {
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    // 从大到小进行排序
    private static void insertSort2(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int temp = arr[i];
            System.out.println(Arrays.toString(arr));
            for (int j=i-1;j>=0;j--) {
                if (arr[j] < temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 从小到大排序
    private static void insertSort(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int temp = arr[i];
            System.out.println(Arrays.toString(arr));
            // 暴力枚举进行交换排序
            for (int j=i-1;j>=0;j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else
                    break;
            }
        }
    }




    // 插入排序：优化  折半插入 ( 折半查找！！！）

}
