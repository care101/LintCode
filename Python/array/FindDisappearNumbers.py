# -*- coding:UTF-8 -*-
class Solution:
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        @ Solution:
        - 定义一个与数组长度等长的数组ans，初始化为1~n;
        - 遍历原数组，清除ans对应位置数字，改为0；
        - 遍历ans数组，把为0的位置删掉，主要要倒着遍历，因为del ans[j]的时候，ans下标发生变化，倒着遍历不会影响前面的下标；
        """
        l = len(nums)
        if l < 2:
            return []
        
        ans = [n for n in range(1, l+1)]
        for i in range(l):
            temp = nums[i] - 1
            ans[temp] = 0
        for j in range(l-1, -1, -1):
            if ans[j] == 0:
                del ans[j]
                
        return ans