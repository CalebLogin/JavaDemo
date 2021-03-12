package com.eric.offerdemo;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * @author：hanzhigang
 * @Date : 2021/3/6 8:27 PM
 */
public class OfferDemo29 {
    //  初步思路，双指针，当完成一次顺时针后，行和列的长度减一，直到行为0或列为0为止
    public int[] spiralOrder(int[][] matrix) {
//      如果数组为空，返回空数组
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
//      数组行的最小下标，最大下标和列的最小下标，最大下标
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
//      返回数组的长度并新建一个数组
        int size = matrix[0].length * matrix.length;
        int[] res = new int[size];
//      遍历行的指针、列的指针以及计数器判断是否添加完成
        int i = 0, j = 0, count = 0;
        while (startRow <= endRow && startCol <= endCol) {
//          自左向右打印
            while (j <= endCol) {
                res[count] = matrix[startRow][j++];
                count++;
            }
//          如果打印在此结束，break
            if (size == count) break;
            startRow++;
            i = startRow;
//          自上向下打印
            while (i <= endRow) {
                res[count] = matrix[i++][endCol];
                count++;
            }
//          如果打印在此结束，break
            if (size == count) break;
            endCol--;
            j = endCol;
//          自右向左打印
            while (j >= startCol) {
                res[count] = matrix[endRow][j--];
                count++;
            }
//          如果打印在此结束，break
            if (size == count) break;
            endRow--;
            i = endRow;
//          自下向上打印
            while (i >= startRow) {
                res[count] = matrix[i--][startCol];
                count++;
            }
//          如果打印在此结束，break
            if (size == count) break;
            startCol++;
            i = startRow;
            j = startCol;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        OfferDemo29 offerDemo29 = new OfferDemo29();
        offerDemo29.spiralOrder(matrix);
    }
}
