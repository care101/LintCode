# -*- coding:UTF-8 -*-
class Solution:
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        @ Solution:
        - 使用动态规划（DP）；使用一个与cost等长的数组，用来存放走到当前位置的最小花费；
        - 设走到第i个位置的花费是ans[i],则 ans[i] = min(ans[i-1],ans[i-2]) + cost[i];
        - 走到终点的最小花费为最后两个值中的较小值；
        """
        ans = []
        ans.append(cost[0])
        ans.append(cost[1])
        for i in range(2, len(cost)):
            temp = min(ans[i-1], ans[i-2]) + cost[i]
            ans.append(temp)
            
        return min(ans[-1], ans[-2])
            
        