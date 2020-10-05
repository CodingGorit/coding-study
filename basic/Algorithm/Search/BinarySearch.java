package Algorithm.search;

/**
 * 二分查找
 * 二分查找的基础是，元素是顺序排序的
 * 找到中间位置的元素的算法： 起始元素 + 末尾元素  /2
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
        int target = 10; // 目标元素
        // 记录开始位置
        int begin = 0;
        // 记录结束位置
        int end = arr.length-1;
        // 记录中间位置
        int mid = (begin+end)/2;
        // 记录目标位置
        int index = -1;
        // 中间位置等于 开始位置 + 结束位置 /2
        // 循环查找
        while (true) {
            if (begin>=end) {
                index = -1;
                break;
            }
            // 判断中间这个元素是不是要查找的元素
            if (arr[mid] == target) {
                index = mid;
                break;
                // 中间这个元素不是要查找的元素
            } else {
               // 判断中间的这个元素是不是比目标元素大
                if (arr[mid] > target) {
                    end = mid-1; // 结束位置调整到中间位置的一个元素
                } else {
                    begin = mid+1;// 修改开始位置
                }
                // 取出新的中间位置
                mid = (begin+end)/2;
            }
        }
        System.out.println(index);
    }
}
