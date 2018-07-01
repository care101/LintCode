package org.likexin.dp;

public class MinPathSum {

  /**
   * 递归写法（LTD）
   *
   * @param grid: a list of lists of integers
   * @return: An integer, minimizes the sum of all numbers along its path
   */
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    return rec(grid, 0, 0, 0);
  }

  private int rec(int[][] grid, int i, int j, int sum) {
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return sum  + grid[grid.length - 1][grid[0].length - 1];
    }
    if (i == grid.length - 1) {
      return rec(grid, i, j + 1, sum + grid[i][j]);
    }
    if (j == grid[0].length - 1) {
      return rec(grid, i + 1, j, sum + grid[i][j]);
    }

    int sum1 = rec(grid, i + 1, j, sum + grid[i][j]);
    int sum2 = rec(grid, i, j + 1, sum  + grid[i][j]);

    return Math.min(sum1, sum2);
  }

  /**
   * DP
   *
   * @param grid: a list of lists of integers
   * @return: An integer, minimizes the sum of all numbers along its path
   */
  public int minPathSum2(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int row = grid.length;
    int col = grid[0].length;
    int[][] f = new int[row][col];
    f[0][0] = grid[0][0];

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        f[i][0] = grid[i][0] + f[i - 1][0];
        f[0][j] = grid[0][j] + f[0][j - 1];
      }
    }

    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
      }
    }
    return f[row - 1][col - 1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(new MinPathSum().minPathSum(grid));
  }
}
