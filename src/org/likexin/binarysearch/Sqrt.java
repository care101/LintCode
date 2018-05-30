package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/sqrtx/
 *
 * @author Shingo Lee
 */
public class Sqrt {

  /**
   * 典型二分
   *
   * @param x 整数
   * @return 开方运算后的结果
   */
  public int sqrt(int x) {
    if (x < 0) {
      return Integer.MIN_VALUE;
    }
    if (x == 0) {
      return 0;
    }
    long start = 1;
    long end = (long) x;
    while (start + 1 < end) {
      long mid = start + (end - start) / 2;
      if (mid * mid < x) {
        start = mid;
      } else if (mid * mid > x) {
        end = mid;
      } else {
        return (int) mid;
      }
    }
    if (end * end <= x) {
      return (int) end;
    }
    return (int) start;
  }

}
