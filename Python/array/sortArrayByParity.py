# -*- coding:UTF-8 -*-
class Solution:
    def sortArrayByParity(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        @ Solution:
        - 设置odd_area区域。
        """
        if len(A) == 1:
            return A
        odd_area = len(A) - 1
        i = 0
        while i < odd_area:
            if A[i] % 2 != 0:
                temp = A[i]
                A[i] = A[odd_area]
                A[odd_area] = temp
                odd_area -= 1              
            else:
                i += 1
        return A