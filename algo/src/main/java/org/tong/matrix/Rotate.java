package org.tong.matrix;

/**
 * @description:
 * @author: yanghantong
 * @time: 2024/4/26 9:55
 */
public class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {

    }
}
