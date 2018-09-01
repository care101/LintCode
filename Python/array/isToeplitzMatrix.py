# -*- coding:UTF-8 -*-
class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        @ Solution:
        - 利用matrix[i][j]与matrix[i+1][j+1]在同一对角线上这一点；
        """
        m, n = len(matrix), len(matrix[0])
        for i in range(m-1):
            for j in range(n-1):
                if matrix[i][j] != matrix[i+1][j+1]:
                    return False
        return True
        