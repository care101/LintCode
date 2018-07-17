# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param n: non-negative integer, n posts
    @ param k: non-negative integer, k colors
    @ return: an integer, the total number of ways
    @ 思路：DP
    - 建一个dp[]长度与栅栏个数相等，dp[i]表示前i个栅栏的涂法；
    - dp[i]，假设第i个栅栏与第i-1个颜色不同，有(k-1)*dp[i-1]，若相同，则根据规则，i-2与i-1肯定颜色不同，那么有(k-1)*dp[i-2];
    - 公式：dp[i] = (k-1) * dp[i-1] + (k-1) * dp[i-2];
    """
    def numWays(self, n, k):
        # write your code here
        if n < 2 or k < 1:
            return k 
        dp = [k, k*k]
        for i in range(2, n):
            temp = (k-1) * dp[i-1] + (k-1) * dp[i-2]
            dp.append(temp)
            
        return dp[-1]
