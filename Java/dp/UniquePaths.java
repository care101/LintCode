package org.likexin.dp;

public class UniquePaths {

  /**
   *
   * dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
   *
   * @param m: positive integer (1 <= m <= 100)
   * @param n: positive integer (1 <= n <= 100)
   * @return: An integer
   */
  public int uniquePaths(int m, int n) {
    if (m == 0 && n == 0) {
      return 0;
    }
    if (m == 0 || n == 0) {
      return 1;
    }

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

}
