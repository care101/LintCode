package org.likexin.array;

/**
 * http://www.lintcode.com/en/problem/maximum-subarray/
 *
 * @author Shingo Lee
 */
public class MaxSubarray {

  public static void main(String[] args) {
    int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
    System.out.println(new MaxSubarray().maxSubarray(nums));
  }

  /**
   * 贪心算法 TODO 动态规划
   *
   * @param nums 一个数组
   * @return 最大子序列之和
   */
  public int maxSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(max, sum);
      sum = Math.max(sum, 0);
    }
    return max;
  }

}
