# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param obstacleGrid: A list of lists of integers
    @ return: An integer
    @ 思路：DP
    - 设一个与obstacleGrid大小相同的dp数组；
    - 初始化，对于dp[0][i]或者dp[i][0]，在出现1（obstacle）之前，dp值都是1，之后的都是0；
    - 状态方程： dp[i][j] = 0,                        if obstacleGrid[i][j] == 1,
                         = dp[i-1][j] + dp[i][j-1],  else
    """
    def uniquePathsWithObstacles(self, obstacleGrid):
        # write your code here
        if not obstacleGrid: return 0
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        
        if m == 1:
            for i in range(n):
                if obstacleGrid[0][i]: return 0
            return 1 
        if n == 1:
            for i in range(m):
                if obstacleGrid[i][0]: return 0
            return 1 
        
        
        dp = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(m):
            if not obstacleGrid[i][0]: 
                dp[i][0] = 1 
            else: 
                break
        
        for i in range(n):
            if not obstacleGrid[0][i]: 
                dp[0][i] = 1 
            else: 
                break
        
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j]: 
                    dp[i][j] = 0
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
                
        return dp[-1][-1]
                
                
            
