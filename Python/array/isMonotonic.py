# -*- coding:UTF-8 -*-
class Solution:
    def isMonotonic(self, A):
        """
        :type A: List[int]
        :rtype: bool
        @ Solution:
        - 注意要考虑到这种情况：假设一开始的前几个数字全部相同，不要在此之前假设数组为递增或递减；
        - 利用flag来标记当前数组情况；
        """
        flag = 0
        l = len(A)
        for i in range(l-1):
            if flag == 0:
                if A[i] < A[i+1]:
                    flag = 1
                elif A[i] > A[i+1]:
                    flag = -1
                    
            if flag == 1 and A[i] > A[i+1]:
                return False
            if flag == -1 and A[i] < A[i+1]:
                return False            
      
        return True
        
        