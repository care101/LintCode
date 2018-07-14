package org.likexin.dp;

public class UniquePathII {

  /**
   * 将是障碍物的点标记为 0
   *
   * @param obstacleGrid: A list of lists of integers
   * @return: An integer
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null) {
      return 0;
    }
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 1;
      if (obstacleGrid[i][0] == 1) {
        for (int k = i; k < dp.length; k++) {
          dp[k][0] = 0;
        }
        break;
      }
    }
    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = 1;
      if (obstacleGrid[0][i] == 1) {
        for (int k = i; k < dp[0].length; k++) {
          dp[0][k] = 0;
        }
        break;
      }
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i][j-1] + dp[i-1][j];
        }
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }

}
