package org.tong.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 按顺时针螺旋方式返回矩阵的顺序
 * @author: yanghantong
 * @time: 2024/4/23 9:48
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {5,6,7}, {9,10,11}};
//        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//        int[][] matrix = {{1,2,3}};
        List<Integer> integerList = spiralOrder(matrix);

        integerList.forEach(System.out::println);
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //行个数
        int m = matrix.length;
        //列个数
        int n = matrix[0].length;
        int initI = 0, initJ = 0;
        for (;initJ < m && initI < n; m-- , n--) {

            //0.如果只是一行或一列
            if (initJ == m - 1) {
                for (int i = initI; i < n; i++) {
                    result.add(matrix[m - 1][i]);
                }
                break;
            }
            if (initI == n - 1) {
                for (int j = initJ; j < m; j++) {
                    result.add(matrix[j][n - 1]);
                }
                break;
            }

            //取四方形的四条边，1.先取最上面的边
            for (int i = initI; i < n; i++) {
                result.add(matrix[initJ][i]);
            }
            result.remove(result.size() - 1);
            //2.取最右边的边
            for (int j = initJ; j < m; j++) {
                result.add(matrix[j][n - 1]);
            }
            result.remove(result.size() - 1);
            //3.取最下面的边
            for (int i = n - 1; i >= initI; i--) {
                result.add(matrix[m - 1][i]);
            }
            //4.取最左边的边
            result.remove(result.size() - 1);
            for (int j = m - 1; j >= initJ; j--) {
                result.add(matrix[j][initI]);
            }
            //5.去除第一个元素
            result.remove(result.size() - 1);
            initI++;
            initJ++;
        }
        return result;
    }
}
