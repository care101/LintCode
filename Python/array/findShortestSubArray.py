# -*- coding:UTF-8 -*-
class Solution:
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        @ Solution:
        - 遍历一遍数组，使用字典，存放每个数值出现的位置；
        - 遍历字典，计算数组深度，并计算最短长度；
        """
        dic = {}
        for i in range(len(nums)):
            temp = nums[i]
            if temp in dic.keys():
                dic[temp].append(i)
            else:
                dic[temp] = [i]
                
        depth, shortest_len = 0, 0
        for key in dic.keys():
            if depth < len(dic[key]):
                depth = len(dic[key])
                shortest_len = dic[key][-1] - dic[key][0] + 1
            if depth == len(dic[key]):
                shortest_len = min(shortest_len, dic[key][-1] - dic[key][0] + 1)
                
        return shortest_len
        