package com.mm.learn.leetcode;

/**
 * Created by wangmingming on 2019/4/4.
 * 岛屿最大面积
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        int temp = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    temp = maxgirdCheck(grid, i, j, row, col);
                    max = Math.max(max, temp);
                }
            }
        }
        return max;

    }

    private int maxgirdCheck(int[][] grid, int i, int j, int row, int col) {
        grid[i][j] = 0;
        int count = 1;
        if (i > 0 && grid[i - 1][j] == 1)
            count += maxgirdCheck(grid, i - 1, j, row, col);
        if (i < row - 1 && grid[i + 1][j] == 1)
            count += maxgirdCheck(grid, i + 1, j, row, col);
        if (j > 0 && grid[i][j - 1] == 1)
            count += maxgirdCheck(grid, i, j - 1, row, col);
        if (j < col - 1 && grid[i][j + 1] == 1)
            count += maxgirdCheck(grid, i, j + 1, row, col);
        return count;

    }
}
