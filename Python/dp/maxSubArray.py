# -*- coding:UTF-8 -*-
class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        @ Solution:
        - DP，利用前缀和数组；
        - 定义一个前缀和数组prefixSum，第一个值为0，其余的是到nums[i]为止前面所有数字的和，这样的话，
                nums[i] + nums[i+1] + ... + nums[j] = prefixSum[j+1] - prefixSum[i] 
        - 利用DP，设定一个maxSum，minSum（到prefixSum[i]为止最小的Sum），遍历数组prefixSum，maxSum = max(maxSum, prefixSum[i]-minSum)；
        """
        if not nums:
            return None
            
        prefixSum = [0]
        for i in range(len(nums)):
            prefixSum.append(prefixSum[i]+nums[i])
            
        maxSum = prefixSum[1]
        minSum = prefixSum[0]
        for i in range(1, len(prefixSum)):
            maxSum = max(maxSum, prefixSum[i]-minSum)
            if prefixSum[i] < minSum:
                minSum = prefixSum[i]
                
        return maxSum
        