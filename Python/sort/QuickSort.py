# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param A: an integer array
    @ return: nothing
    @ solution: 快排O(N*logN)
    - 快排是随便选择一个数作为参考，对数组进行划分，比它小的放前面，比它大的放后面；
    - 第一次划分的具体过程是,划分时间复杂度O(N)：
        - 定义一个interval（小于区间），初始值为0；
        - 取最后一个数做参考，数组从前面与之比较，比它大的不动，比它小的与array[interval]进行交换，同时interval加1；
        - 最后把参考值放到interval那里去
    - 对数组递归重复这个划分的过程；
    """
    def switch(self, A, i, j):
        temp = A[i] 
        A[i] = A[j] 
        A[j] = temp 
        return A  
    
    def quickSort(self, A, start, end):
        if start >= end:
            return A 
        
        interval = start 
        for i in range(start, end):
            if A[i] < A[end]:
                self.switch(A, i, interval)
                interval += 1 
        self.switch(A, interval, end)   
        
        self.quickSort(A, start, interval-1)
        self.quickSort(A, interval+1, end)
        
        return A 
  
    def sortIntegers(self, A):
        # write your code here
        return self.quickSort(A, 0, len(A)-1)
        
        
        
        