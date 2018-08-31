# -*- coding:UTF-8 -*-
class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        @ Solution:
        - 使用两个指针，index和cur；
        - index指向数组中第一个为0的位置，并且小于cur；
        - cur指向当前正在遍历的值，如果当前值不为0，并且index指向0，二者进行交换；
        """
        if len(nums) > 1:
            index, cur = 0, 0
            while cur < len(nums):
                if nums[cur] != 0 and nums[index] == 0:
                    nums[index] = nums[cur]
                    nums[cur] = 0
                cur += 1
                while nums[index] != 0 and index < cur-1:
                    index += 1
                