package org.likexin.twopointer;

public class QuickSort {

  /**
   * 先整体有序再部分有序。即：先找准一个基准数 pivot，将小于 pivot 的数扔到左边，大于 pivot 的数扔到右边。这样一遍下来已经算是宏观意义上的有序，再递归到左右两边使左右两边都有序。
   * 时间复杂度：O(nlogn)
   * 空间复杂度：O(1)
   */
  public void sortInteger(int[] A) {
    if (A == null || A.length == 0) {
      return;
    }

    quickSort(A, 0, A.length - 1);
  }

  private void quickSort(int[] A, int start, int end) {
    if (start >= end) {
      return;
    }

    int left = start, right = end;
    // 1. pivot is value not index
    int pivot = A[(start + end) / 2];

    // 2. left <= right not left < right,left < right will make stack overflow error
    while (left <= right) {
      // 3. A[left] < pivot not A[left] <= pivot
      while (left <= right && A[left] < pivot) {
        left++;
      }
      while (left <= right && A[right] > pivot) {
        right--;
      }

      if (left <= right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
      }
    }

    quickSort(A, left, end);
    quickSort(A, start, right);
  }

}
