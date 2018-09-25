# -*- coding:UTF-8 -*-
class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        @ Solution：
        - 可以从右上角或者左下角开始找，以右上角为例：（temp_i，temp_j是当前所在的位置）
            - 如果target大于当前值，要往下找，行加1；
            - 如果target小于当前值，要往左找，列减1；
            - 相等则返回TRUE；
        """
        if not matrix:
            return False
        row, col = len(matrix), len(matrix[0])
        temp_i, temp_j = 0, col-1
        while 0 <= temp_i < row and 0 <= temp_j < col:
            if target > matrix[temp_i][temp_j]:
                temp_i += 1
            elif target < matrix[temp_i][temp_j]:
                temp_j -= 1
            else:
                return True
        return False