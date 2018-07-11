# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param nums: An integer array
    @ return: The length of LIS (longest increasing subsequence)
    @ lsy
    @ 思路：
    - DP，建一个与数组长度相同的数组dp, dp[i]表示的含义是必须以nums[i]为结尾的最长递增子序列的长度；
    - 那dp[i]的值就是在前面，看前i-1个值中，看比nums[i]小的数中，哪一个dp对应的值最大，也就是最长的那个子序列，在这个值得基础上加1；
    - 最后返回dp数组中的最大值；
    - 时间复杂度O(n^2)      
    """
    def longestIncreasingSubsequence(self, nums):
        # write your code here
        if len(nums) == 0:
            return 0
        
        dp = [1]
        for i in range(1, len(nums)):
            len_max = 0 
            for j in range(0, i):
                if nums[j] < nums[i] and dp[j] > len_max:
                    len_max = dp[j]
            dp.append(len_max + 1)
        
        return max(dp)
            

