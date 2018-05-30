package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/sqrtx-ii/
 *
 * @author Shingo Lee
 */
public class SqrtII {

  public static void main(String[] args) {
    System.out.println(new SqrtII().sqrt(0.5));
  }

  /**
   * 注意两点：
   * 1. 因为输入的数是浮点数，所以对它开方的结果可能是个无限循环小数，因此我们需要设置一个精度。题目要求是小数点后8位，这里设置1e-10就能AC了。
   * 2. 对小于1的数的处理，两个小于1的数相乘可能比原来的数更小，所以要将有边界移到1。
   *
   * @param x 一个浮点数
   * @return 它开平方的结果
   */
  public double sqrt(double x) {
    double start = 0;
    double end = x;
    double eps = 1e-10;

    if (x < 1.0) {
      end = 1.0;
    }

    while (start + eps < end) {
      double mid = start + (end - start) / 2;
      if (mid * mid < x) {
        start = mid;
      } else if (mid * mid > x) {
        end = mid;
      } else {
        return mid;
      }
    }

    return start;
  }

}
