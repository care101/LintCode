class Solution:
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        max_cnt, cnt = 0, 0
        for i in range(l):
            if nums[i] == 1:
                cnt += 1
            else:
                cnt = 0
            if max_cnt < cnt:
                max_cnt = cnt
                
        return max_cnt
                