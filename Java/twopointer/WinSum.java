package org.likexin.twopointer;

public class WinSum {

  /**
   * 这个解法比较直接，slow和fast指针分别指向滑动窗口的左边界和右边界，依次++求出窗口中的和。
   * 注意results的长度是nums.length-k+1.
   */
  public int[] winSum(int[] nums, int k) {
    int[] results = new int[nums.length - k + 1];
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int slow = 0, fast = k - 1;
    while (fast < nums.length) {
      int sum = 0;
      for (int i = slow; i <= fast; i++) {
        sum += nums[i];
      }
      results[slow++] = sum;
      fast++;
    }
    return results;
  }

  /**
   * 这个解法在计算窗口的和时只关注窗口进来和出去的，加上进来的值以及减去出去的值就是现在窗口的和。
   * 例如：
   *  | 1, 2, 7 | 8, 5  ==> 1 | 2, 7, 8 | 5 ====> 那么减去1，加上8就是现在窗口的和。
   */
  public int[] winSum2(int[] nums, int k) {
    int[] results = new int[nums.length - k + 1];
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    for (int i = 0; i < k; i++) {
      results[0] += nums[i];
    }
    for (int i = 1; i < results.length; i++) {
      results[i] = results[i - 1] - nums[i - 1] + nums[i + k - 1];
    }
    return results;
  }

}
