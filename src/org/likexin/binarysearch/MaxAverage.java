package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/maximum-average-subarray/
 *
 * @author Shingo Lee
 */
public class MaxAverage {

  public static void main(String[] args) {
    int[] nums = {1, 12, -5, -6, 50, 3};
    System.out.println(new MaxAverage().maxAverage(nums, 3));
  }

  /**
   * reference: http://www.lintcode.com/en/problem/maximum-average-subarray/
   *
   * @param nums 有正有负的数组
   * @param k    输出数组的长度
   * @return 连续的k个平均值最小的子序列
   */
  public double maxAverage(int[] nums, int k) {
    // Write your code here
    double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] < l)
        l = nums[i];
      if (nums[i] > r)
        r = nums[i];
    }


    while (r - l >= 1e-6) {
      double mid = (l + r) / 2.0;

      if (check_valid(nums, mid, k)) {
        l = mid;
      } else {
        r = mid;
      }
    }

    return l;
  }

  private boolean check_valid(int nums[], double mid, int k) {
    int n = nums.length;
    double min_pre = 0;
    double[] sum = new double[n + 1];
    sum[0] = 0;
    for (int i = 1; i <= n; ++i) {
      sum[i] = sum[i - 1] + nums[i - 1] - mid;
      if (i >= k && sum[i] - min_pre >= 0) {
        return true;
      }
      if (i >= k)
        min_pre = Math.min(min_pre, sum[i - k + 1]);
    }
    return false;
  }

}
