package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/total-occurrence-of-target/
 *
 * @author Shingo Lee
 */
public class TotalOccurrence {

    /**
     *
     * O(n)的算法是直接遍历数组找，O(longN)的算法是使用两次二分: 先找出target第一次出现的位置，再找出target最后一次出现的位置，最后求个距离差就是target总共出现的次数了。
     * 要注意与FirstPosition、LastPosition在处理start与end位置上的不同之处；
     * 以及第一次位置与最后一次位置初值的设定上，要能够保证在没找到的情况下输出是0。
     *
     * @param A 目标数组(已排好序)
     * @param target 目标元素
     * @return 目标元素在目标数组中出现的次数
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // 找第一次出现的位置
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int index1 = 0;
        if (A[end] == target) {
            index1 = end;
        }
        if (A[start] == target) {
            index1 = start;
        }
        // 找最后一次出现的位置
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int index2 = -1;
        if (A[start] == target) {
            index2 = start;
        }
        if (A[end] == target) {
            index2 = end;
        }
        return index2 - index1 + 1;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,1,1};
        System.out.println(new TotalOccurrence().totalOccurrence(A, 1));
    }

}
