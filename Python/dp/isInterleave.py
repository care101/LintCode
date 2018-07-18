# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param s1: A string
    @ param s2: A string
    @ param s3: A string
    @ return: Determine whether s3 is formed by interleaving of s1 and s2
    @ 思路：DP
    - 特殊情况：如果三个都是空串，那么返回True; 否则如果s1,s2加起来长度不等于s3那么返回False.
    - 设 m, n, l = len(s1), len(s2), len(s3)，建一个数组dp[n+1][m+1];
    - dp[i][j]表示s1的前i个元素和s2前j个元素能否组成s3的前i+j个元素；
    - 初始化dp，dp[0][i]表示的是当s2为空，s1能否与s3匹配的问题，那么dp[0][i] = dp[0][i-1] and s1[i-1] == s3[i-1];同理初始化dp[i][0];
    - 公式： dp[i][j] = (dp[i-1][j] and s2[i-1] == s3[i+j-1]) or (dp[i][j-1] and s1[j-1] == s3[i+j-1])
    """
    def isInterleave(self, s1, s2, s3):
        # write your code here
        m, n, l = len(s1), len(s2), len(s3)
        if m == 0 and n == 0 and l == 0: 
            return True
        if m + n != l:
            return False
            
        dp = [[False for i in range(m+1)] for j in range(n+1)]
        dp[0][0] = True
        for i in range(1, m+1):
            dp[0][i] = dp[0][i-1] and s1[i-1] == s3[i-1]
        for i in range(1, n+1):
            dp[i][0] = dp[i-1][0] and s2[i-1] == s3[i-1]
            
        for i in range(1, n+1):
            for j in range(1, m+1):
                dp[i][j] = (dp[i-1][j] and s2[i-1] == s3[i+j-1]) or \
                           (dp[i][j-1] and s1[j-1] == s3[i+j-1])
                     
                     
        return dp[-1][-1]
