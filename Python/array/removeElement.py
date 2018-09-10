# -*- coding:UTF-8 -*-
class Solution:
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        @ Solution:
        - 定义一个val区域，专门用来存放val值；遍历数组，发现val值时，把他与val区域前面一个值交换，并扩充val区域；
        - 用val_area放在最后，前面数值与之交换时，注意i不进行加1操作，因为后面区域的数值没有进行过检查；
        - 判断是令i <= val_area即可，后面的区域都是val值，不需要再进行检查； 
        """
        val_area = len(nums)-1
        i = 0
        while i <= val_area and val_area >= 0:
            if nums[i] == val:
                nums[i] = nums[val_area]
                nums[val_area] = val
                val_area -= 1
            else:
                i += 1
                
        return val_area + 1