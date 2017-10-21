package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
 *
 * @author Shingo Lee
 */
public class Search {

    /**
     * 和 findMin 那道题类似，首先判断中间的数和右边的数来确定哪半边是有序的。由于二分法一般基于有序的数组，因此再去有序的那半边查找目标元素。
     *
     * @param A 目标数组
     * @param target 目标元素
     * @return 目标元素穿在目标数组中的下标
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[end]) { // 左边有序
                if (target > A[start] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { // 右边有序
                if (target > A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(new Search().search(A, 5));
    }

}
