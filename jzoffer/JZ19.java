package cn.gorit.jzoffer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */
public class JZ19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) return res;
        int left=0,top=0,right=col-1,bottom=row-1;
        while (left<=right && top<=bottom) {
            // left to right
            for (int i = left; i <= right;i++) res.add(matrix[top][i]);
            // top to bottom
            for (int i = top+1; i<= bottom;++i) res.add(matrix[i][right]);
            // right to left
            for (int i = right-1;i >= left && bottom > top; i--) res.add(matrix[bottom][i]);
            // bottom to top
            for (int i = bottom-1; i > top && left < right; i--) res.add(matrix[i][left]);
            left++;top++;right--;bottom--;
        }
        return res;
    }
}
