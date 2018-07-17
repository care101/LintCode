# -*- coding:UTF-8 -*-
'''
@ 思路：数组前缀和
- 利用数组前缀和，避免重复计算；
- 数组前缀和就是新建一个数组subPrefix，用来存放到当前位置为止所有的数字和，那么i到j位置的数字和就是subPrefix[j+1] - subPrefix[i];
'''
class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.subPrefix = [0]
        for i in range(len(nums)):
            self.subPrefix.append(self.subPrefix[i] + nums[i])
        

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.subPrefix[j+1] - self.subPrefix[i]
        
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)