package org.likexin.dfs;

public class Triangle {

  private int best = Integer.MAX_VALUE;
  private int[][] hash;

  /**
   *
   * Traverse(TLD): O(2^n)
   * @param triangle: a list of lists of integers
   * @return: An integer, minimum path sum
   */
  public int minimumTotal(int[][] triangle) {
    if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
      return Integer.MIN_VALUE;
    }

    int row = triangle.length;

    traverse(0, 0, 0, row, triangle);
    return best;
  }

  private void traverse(int x, int y, int sum, int row, int[][] triangle) {
    if (x == row) {
      if (sum < best) {
        best = sum;
      }
      return;
    }

    traverse(x + 1, y, sum + triangle[x][y], row, triangle);
    traverse(x + 1, y + 1, sum + triangle[x][y], row, triangle);
  }

  /**
   *
   * Divide Conquer(TLD): O(2^n)
   * @param triangle: a list of lists of integers
   * @return: An integer, minimum path sum
   */
  public int minimumTotal2(int[][] triangle) {
    if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
      return Integer.MIN_VALUE;
    }

    int row = triangle.length;

    return divideConquer(0, 0, row, triangle);
  }

  private int divideConquer(int x, int y, int row, int[][] triangle) {
    if (x == row) {
      return 0;
    }
    return triangle[x][y] + Math.min(
      divideConquer(x + 1, y, row, triangle),
      divideConquer(x + 1, y + 1, row, triangle)
    );
  }

  /**
   *
   * Divide Conquer + Memorization: O(n^2)
   * @param triangle: a list of lists of integers
   * @return: An integer, minimum path sum
   */
  public int minimumTotal3(int[][] triangle) {
    if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
      return Integer.MIN_VALUE;
    }

    int row = triangle.length;
    int col = triangle[row - 1].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        hash[i][j] = Integer.MAX_VALUE;
      }
    }

    return divideConquerWithMemorization(0, 0, row, triangle);
  }

  private int divideConquerWithMemorization(int x, int y, int row, int[][] triangle) {
    if (x == row) {
      return 0;
    }
    if (hash[x][y] != Integer.MAX_VALUE) {
      return hash[x][y];
    }
    hash[x][y] = triangle[x][y] + Math.min(
      divideConquer(x + 1, y, row, triangle),
      divideConquer(x + 1, y + 1, row, triangle)
    );
    return hash[x][y];
  }

  public static void main(String[] args) {
    int[][] matrix = {{2, 0, 0}, {3, 4, 0}, {6, 5, 7}, {4, 1, 8, 3}};
    System.out.println(new Triangle().minimumTotal2(matrix));
  }

}
