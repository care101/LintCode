package org.likexin.array;

/**
 * http://www.lintcode.com/en/problem/maximum-subarray/
 *
 * @author Shingo Lee
 */
public class MaxSubarray {

  /**
   * 子数组前缀和
   *
   * @param nums: A list of integers
   * @return: A integer indicate the sum of max subarray
   */
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int prefixSum = 0, sum = 0, max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      max = Math.max(prefixSum - sum, max);
      sum = Math.min(prefixSum, sum);
    }
    return max;
  }

}
