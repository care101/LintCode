class Solution:
    """
    @param nums: A list of integers
    @return: A integer indicate the sum of max subarray
    """
    def maxSubArray(self, nums):
        # write your code here
        preSum = []
        temp = 0
        
        for i in range(len(nums)):
          preSum.append(temp)
          temp += nums[i]
        preSum.append(temp)  
        
        temp = preSum[0]
        maxSum = preSum[1]
        for j in range(len(preSum) - 1):
          temp = min(temp, preSum[j]) 
          maxSum = max(maxSum, preSum[j+1]-temp)
        return maxSum
          
          
  