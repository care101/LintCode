# -*- coding:UTF-8 -*-
class Solution:
    '''
    @ Solution:
    - 实质就是数组排序，取排序后数组下标为偶数的加和；
    '''
    def swap(self, a, b):
        temp = a
        a = b
        b = temp
        return a, b
    
    
    def quickSort(self, A, start, end):
        if start >= end:
            return A
        interval = start
        reference = A[end]
        for i in range(start, end):
            if A[i] < reference:
                A[interval], A[i] = self.swap(A[interval], A[i])
                interval += 1
        A[interval], A[end] = self.swap(A[interval], A[end])
        
        A = self.quickSort(A, start, interval-1)
        A = self.quickSort(A, interval+1, end)
        
        return A
        
        
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = self.quickSort(nums, 0, len(nums)-1)
        res = 0
        for i in range(0, len(nums), 2):
            res += nums[i]
        
        return res

        
        