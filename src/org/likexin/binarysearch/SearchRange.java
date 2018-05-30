package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/search-for-a-range/
 *
 * @author Shingo Lee
 */
public class SearchRange {

  /**
   * 两次二分，一次找first position，一次找last position。注意停留在start和end位置的处理，以及index1和index2的初值。
   *
   * @param A      目标数组
   * @param target 目标元素
   * @return 目标元素在目标数组中第一次和最后一次出现的范围
   */
  public int[] searchRange(int[] A, int target) {
    if (A == null || A.length == 0) {
      return new int[]{-1, -1};
    }
    int index1 = -1;
    int index2 = -1;
    int start = 0;
    int end = A.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] == target) {
        end = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[end] == target) {
      index1 = end;
    }
    if (A[start] == target) {
      index1 = start;
    }
    start = 0;
    end = A.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (A[mid] == target) {
        start = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[start] == target) {
      index2 = start;
    }
    if (A[end] == target) {
      index2 = end;
    }
    return new int[]{index1, index2};
  }

}
