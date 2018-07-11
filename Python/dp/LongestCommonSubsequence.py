# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param A: A string
    @ param B: A string
    @ return: The length of longest common subsequence of A and B
    @ lsy
    @ 思路：DP
    - 建一个数组dp[len(A)][len(B)], dp[i][j]表示的是A[i]和B[j]的最长公共子序列的长度；
    - 对dp进行初始化，对于dp[i][0]，代表的是A[i]与B[0]的最长公共子串，当A[i]==B[0]时，从这一位到后面的都是1，最长子序列长度是1；同理dp[0][i];
    - 状态方程： dp[i][j] = | dp[i-1][j-1] + 1,              if A[i] == B[j]
                           | max(dp[i-1][j], dp[i][j-1]),   else
    """
    def longestCommonSubsequence(self, A, B):
        # write your code here
        if len(A) == 0 or len(B) == 0:
            return 0
            
        dp = [[0 for i in range(len(B))] for j in range(len(A))]
        
        for i in range(len(A)):
            if A[i] == B[0]:
                for j in range(i, len(A)):
                    dp[j][0] = 1
                break
        for i in range(len(B)):
            if A[0] == B[i]:
                for j in range(i, len(B)):
                    dp[0][j] = 1 
                break
        
        for i in range(1, len(A)):
            for j in range(1, len(B)):
                if A[i] == B[j]:
                    dp[i][j] = dp[i-1][j-1] + 1 
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return dp[-1][-1]
                
