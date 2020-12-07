package cn.gorit.jzoffer;

/**
 * 调整数组中奇数和偶数的位置
 */
public class JZ13 {
    public void reOrderArray(int [] array) {
        int[] res = new int[array.length];
        int t = 0;
        for (int i=0;i<array.length;i++) {
            if (array[i]%2!=0) {
                res[t++] = array[i];
            }
        }
        for (int i=0;i<array.length;i++) {
            if (array[i]%2==0) {
                res[t++] = array[i];
            }
        }
        System.arraycopy(res,0,array,0,array.length);
    }
}
