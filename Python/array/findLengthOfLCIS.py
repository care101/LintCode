class Solution:
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        longest_len, count = 1, 1
        for i in range(len(nums)-1):
            if nums[i] < nums[i+1]:
                count += 1
            else:
                count = 1
            if longest_len < count:
                longest_len = count
                
        return longest_len
                
        