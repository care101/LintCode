package org.likexin.dp;

public class LongestIncreasingSubsequence {
  /**
   * @param nums: An integer array
   * @return: The length of LIS (longest increasing subsequence)
   */
  public int longestIncreasingSubsequence(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        dp[i] = 1;
      }
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < dp.length; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {10,1,11,2,12,3,11};
    System.out.println(new LongestIncreasingSubsequence().longestIncreasingSubsequence(nums));
  }
}
