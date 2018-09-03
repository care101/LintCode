# -*- coding:UTF-8 -*-
class Solution:
    '''
    @ Solution:
    - 使用二分查找
    '''
    def binarysearch(self, A, target, start, end):
        while start <= end:
            mid = int((start+end)/2)
            if target < A[mid]:
                end = mid - 1
            elif target > A[mid]:
                start = mid + 1
            else:
                return mid
        return -1
    
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        l = len(numbers)
        for i in range(l):
            temp = self.binarysearch(numbers, target - numbers[i], i+1, l-1)
            if temp != -1:
                return [i+1, temp+1]
            
                
               