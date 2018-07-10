package org.likexin.dp;

public class LongestCommonSubsequence {
  /**
   * @param A: A string
   * @param B: A string
   * @return: The length of longest common subsequence of A and B
   */
  public int longestCommonSubsequence(String A, String B) {
    if (A == null || A.length() == 0 || B == null || B.length() == 0) {
      return 0;
    }
    int[][] dp = new int[A.length()][B.length()];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 0;
      if(A.charAt(i) == B.charAt(0)) {
        for (int k = i; k < dp.length; k++) {
          dp[k][0] = 1;
        }
        break;
      }
    }
    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = 0;
      if(B.charAt(j) == A.charAt(0)) {
        for (int k = j; k < dp[0].length; k++) {
          dp[0][k] = 1;
        }
        break;
      }
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        int temp1 = dp[i - 1][j];
        int temp2 = dp[i][j - 1];
        dp[i][j] = Math.max(temp1, temp2);
        if (A.charAt(i) == B.charAt(j)) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }
}
