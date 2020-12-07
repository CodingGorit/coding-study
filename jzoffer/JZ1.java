package cn.gorit.jzoffer;

/**
 * 二维数组中的查找
 */
public class JZ1 {
    public boolean Find(int target, int [][] array) {
        int row = array.length; // 获取二维数组的行数
        int col = array[0].length; // 获取二维数组的列
        for (int i=0;i<col;i++) {
            for (int j=0;j<row;j++) {
                if (array[j][i] == target)
                    return true;
            }
        }
        return false;
    }
}
