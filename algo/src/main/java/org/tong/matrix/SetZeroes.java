package org.tong.matrix;


/**
 * @description: 矩阵置零
 * @author: yanghantong
 * @time: 2024/4/29 10:27
 */
public class SetZeroes {
    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    //我认为原地算法就是记录重复状态，记录之前的状态和现在的状态
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean clearFlag = false;

        //1.先按照行进行清除
        //清楚规则:有0的那一行除了0之外全部置为0，0置为1
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[j][i] == 0) {
                    clearFlag = true;
                    break;
                }
            }
            if (clearFlag) {
                for (int i = 0; i < n; i++) {
                    if (matrix[j][i] == 0) {
                        matrix[j][i] = 1;
                    }else {
                        matrix[j][i] = 0;
                    }
                }
                clearFlag = false;
            }
        }
        //2.接着按列进行清除，如果这个数为1，并且左边或右边的数有0，将这列数全部置为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == 1 && (i - 1 >= 0 && matrix[j][i - 1] == 0) || (i + 1 < n && matrix[j][i + 1] == 0)) {
                    clearFlag = true;
                    break;
                }
            }
            if (clearFlag) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
