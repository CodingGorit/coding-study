package cn.gorit.jzoffer;

/**
 * 旋转数组的最小数字
 * 2020年12月3日13:40:59
 *
 * 给定一个非递减排序数列，然后反转一部分
 * 1 2 3 4 5 （随机输入的数组）
 * 5 4 3 1 2 （翻转后的数组） 题目有规律的
 * 5 1 2 3 4 （数组也有可能是这样）
 * 使用双指针来判断：递减 递增，找到临界点
 */
public class JZ6 {
    public int minNumberInRotateArray(int [] array) {
        for (int i=0,j=array.length-1;i<j;i++,j--) {
            if (array[i]>array[i+1]) return array[i+1];
            if (array[j]<array[j-1]) return array[j];
        }
        return array.length==0?0:array[0];
    }
}
