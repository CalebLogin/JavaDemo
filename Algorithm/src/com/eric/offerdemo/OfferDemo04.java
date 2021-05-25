package com.eric.offerdemo;

/**
 * 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author：hanzhigang
 * @Date : 2021/3/1 11:24 PM
 */
public class OfferDemo04 {

/**
 * 在右上角开始查找，类似于二叉搜索数，target比当前值小就向左边，比当前值大就向右边
 */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

//      如果数组为空，不存在target，返回false
        if (matrix==null||matrix.length == 0 || matrix[0].length==0) {
            return false;
        }

//      row表示有几行，col表示有几列
        int row = matrix.length;
        int col = matrix[0].length;

//      i所处行号，j表示所处列号
        int i = 0, j = col-1;

        while (i < row && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}
