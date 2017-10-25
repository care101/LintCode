package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/search-a-2d-matrix/
 *
 * @author Shingo Lee
 */
public class Search2DMatrix {

    /**
     * 两次二分，先找行再找列。
     * @param matrix 二维数组
     * @param target 目标元素
     * @return 目标元素是否存在与二维数组中
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target) {
                start = mid;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        int row = matrix[end][0] <= target ? end : start;
        start = 0;
        end = matrix[row].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] < target) {
                start = mid;
            } else  if (matrix[row][mid] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        }
        if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }

    /**
     * 一次二分，把二维矩阵看成一个有序数组。
     * @param matrix 二维数组
     * @param target 目标元素
     * @return 目标元素是否存在与二维数组中
     */
    public boolean searchMatrixByOnceBinarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] < target) {
                start = mid;
            } else if (matrix[row][col] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        if (matrix[start / n][start % n] == target) {
            return true;
        }
        if (matrix[end / n][end % n] == target) {
            return true;
        }
        return false;
    }

}
