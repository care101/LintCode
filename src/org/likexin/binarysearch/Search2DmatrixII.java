package org.likexin.binarysearch;

/**
 * http://www.lintcode.com/en/problem/search-a-2d-matrix-ii/
 *
 * @author Shingo Lee
 */
public class Search2DmatrixII {

    /**
     * 从左下角或者右上角出发，与target比较，在O(1)的时间内排除掉一行或一列的元素，时间复杂度为O(m+n)。
     *
     * @param matrix 二维数组
     * @param target 目标元素
     * @return 目标元素在二维数组中出现的次数
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;

        while (x >= 0 && x < m && y >= 0 && y < n) {
            if (target == matrix[x][y]) {
                result++;
                x--;
                y++;
            } else if (target > matrix[x][y]) {
                y++;
            } else {
                x--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{3,11,16,20},{23,30,34,50}};
        System.out.println(new Search2DmatrixII().searchMatrix(matrix, 3));
    }

}
