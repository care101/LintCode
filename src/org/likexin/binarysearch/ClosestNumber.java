package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/closest-number-in-sorted-array/
 *
 * @author Shingo Lee
 */
public class ClosestNumber {

    /**
     * 典型二分法模版，如果目标元素不存在于目标数组中，则判断start与end停留的位置。
     *
     * @param A 目标数组
     * @param target 目标元素
     * @return 目标数组中离目标元素最近的索引
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.abs(A[start] - target) > Math.abs(A[end] - target) ? end : start;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 3, 4};
        System.out.println(new ClosestNumber().closestNumber(A, 5));
    }

}
