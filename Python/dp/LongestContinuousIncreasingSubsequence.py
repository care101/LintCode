# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param A: An array of Integer
    @ return: an integer
    @ 思路：DP
    - 设定一个标志位flag用来表示以当前位置结束的序列是一个递增序列还是递减序列；
    - 用max_count来记录当前为止最长的递增子序列；
    - max_count和count的初始值都是2，因为最短的递增子序列一定大于等于2（序列长度大于2时）；
    """
    def longestIncreasingContinuousSubsequence(self, A):
        # write your code here
        if len(A) < 2:
            return len(A)
        
        max_count, count = 2, 2
        if A[0] < A[1]:
            flag = 1
        else:
            flag = 0 
        for i in range(1, len(A)-1):
            if A[i] < A[i+1]:
                if flag == 1:
                    count += 1 
                else:
                    count = 2
                    flag = 1 
            if A[i] > A[i+1]:
                if flag == 0:
                    count += 1            
                else:
                    count = 2                  
                    flag = 0 
            max_count = max(count, max_count)
            print(count, flag, max_count)
        
        return max_count
