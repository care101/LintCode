# -*- coding:UTF-8 -*-
class Solution:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        @ Solution:
        - 因为出现的数字是连续的，可以利用1+2+...+n = n*(n+1)/2;
        - 注意：Python3除法返回的是float，要用int转一下；
        """
        n = len(nums)
        return int(n*(1+n)/2) - sum(nums)
        