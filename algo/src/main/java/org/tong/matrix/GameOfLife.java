package org.tong.matrix;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import java.util.zip.CheckedOutputStream;

/**
 * @description: 生命游戏
 * @author: yanghantong
 * @time: 2024/4/25 9:49
 */
public class GameOfLife {

    public static void main(String[] args) {
//        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board = {{1,1}, {1,0}};
        gameOfLife(board);
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        //1.复制原数组，需要原数组的值计算白细胞的数量
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                temp[j][i] = board[j][i];
            }
        }

        for (int j = 0; j < m; j++) {
             for (int i = 0; i < n; i++) {
                //2.计算周围细胞的数量
                int count = countWhite(temp, j, i);
                //根据规则统计数量
                if (count < 2) {
                    board[j][i] = 0;
                }
                if (count == 3) {
                    board[j][i] = 1;
                }
                if (count > 3) {
                    board[j][i] = 0;
                }
            }
        }
    }
    
    /**
     * 统计周围白色细胞的个数
     */
    public static int countWhite(int[][] target, int j, int i) {
        int m = target.length;
        int n = target[0].length;
        int count = 0;
        int initJ = Math.max(j - 1, 0);
        int initI = Math.max(i - 1, 0);
        m = Math.min(j + 1, m - 1);
        n = Math.min(i + 1, n - 1);

        for (int j1 = initJ; j1 <= m; j1++) {
            for (int i1 = initI; i1 <= n; i1++) {
                count += target[j1][i1];
            }
        }
        count = count - target[j][i];
        return count;
    }
}
