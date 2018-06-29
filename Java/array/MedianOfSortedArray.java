package org.likexin.array;

public class MedianOfSortedArray {

  /*
   * @param A: An integer array
   * @param B: An integer array
   * @return: a double whose format is *.5 or *.0
   */
  public double findMedianSortedArrays(int[] A, int[] B) {
    if (A == null || A.length == 0 && B == null || B.length == 0) {
      return 0.00;
    }
    int index = 0;
    int[] temp = new int[6];
    int aIndex = 0;
    int bIndex = 0;
    while (aIndex < A.length && bIndex < B.length) {
      if (A[aIndex] > B[bIndex]) {
        temp[index++] = B[bIndex++];
      } else {
        temp[index++] = A[aIndex++];
      }
    }
    while (aIndex < A.length) {
      temp[index++] = A[aIndex++];
    }
    while (bIndex < B.length) {
      temp[index++] = B[bIndex++];
    }

    if (temp.length % 2 == 0) {
      return temp[temp.length / 2];
    } else {
      return (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
    }
  }
}