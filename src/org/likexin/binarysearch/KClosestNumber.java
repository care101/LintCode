package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/k-closest-numbers-in-sorted-array/
 *
 * @author Shingo Lee
 */
public class KClosestNumber {

    /**
     *
     * 总体方案是使用二分法与双指针，二分法用于定位目标数组中距离target最近的位置，找到了这个位置之后，再使用双指针扩散这个位置两边的数，直到找到k个数。
     * 注意：在二分法中，target存在于数组A与target不存在于数组A中返回的值不同(参照ClosestNumber这题)，这样返回的位置不确定的话，双指针的位置也不一定确定。
     *      所以这里让二分法返回距离target最近的位置的前一位。
     *
     * @param A 目标数组(已排好序)
     * @param target 目标元素
     * @param k 输出数组大小
     * @return 距离target最近的k个数
     */
    public int[] kClosestNumber(int[] A, int target, int k) {
        if (A == null || A.length == 0) {
            return null;
        }

        int index = firstIndex(A, target);
        int[] res = new int[k];

        int start = index - 1;
        int end = index;
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                res[i] = A[end++];
            } else if (end >= A.length) {
                res[i] = A[start--];
            } else {
                if (Math.abs(target - A[start]) <= Math.abs(target - A[end])) {
                    res[i] = A[start--];
                } else {
                    res[i] = A[end++];
                }
            }
        }
        return res;
    }

    private int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 6, 8};
        int[] res = new KClosestNumber().kClosestNumber(A, 4, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
