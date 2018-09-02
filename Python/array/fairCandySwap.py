# -*- coding:UTF-8 -*-
class Solution:
     def fairCandySwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        @ Solution:
        - x,y分别为A，B的和，假设a,b分别是A,B要拿出的糖果，那么 x-a+b = y-b+a, 则 b = a - (x-y)/2
        - 这边对B用到了set,不然会超时；（用binary search的话，要先对数组排序，也会超时）;
        """
        x, y = sum(A), sum(B)
        B = set(B)
        for i in range(len(A)):
            a = A[i]
            b = A[i] - (x-y)/2
            if b > 0 and b in B:
                return [a, b]
         
        