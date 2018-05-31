package org.likexin.twopointer;

public class QuickSort {

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
