package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/find-peak-element/
 *
 * @author Shingo Lee
 */
public class FindPeak {

  public static void main(String[] args) {
    int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
    System.out.println(new FindPeak().findPeak(A));
  }

  /**
   * 让中间的数与其两边的数相比较，再去升序那半边找峰值。
   *
   * @param A 目标数组
   * @return 任意一个峰值
   */
  public int findPeak(int[] A) {
    if (A == null || A.length == 0) {
      return -1;
    }

    int start = 0;
    int end = A.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
        start = mid;
      } else if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
        return mid;
      } else {
        end = mid;
      }
    }
    return -1;
  }

}
