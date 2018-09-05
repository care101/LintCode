# -*- coding:UTF-8 -*-
class Solution:
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        @ Solution:
        - 最大的乘积可能来自于最大三个数的乘积，也可能是两个最小的负数和最大数的乘积；
        - Solution 1：
            - 只考虑上述两种情况，对数组进行5次冒泡排序即可（遍历5次数组），找出最大的三个数和最小的两个数；
            - 时间复杂度 O(n), 无须额外空间；
        - Solution 2:
            - 定义5个值来放最小的两个数和最大的三个数，只需要遍历一遍数组即可；
            - 时间复杂度 O(n), 空间复杂度 O(1)；
        """
        # Solution 1
        for i in range(3):
            for j in range(0, len(nums)-1-i):
                if nums[j] > nums[j+1]:
                    temp = nums[j]
                    nums[j] = nums[j+1]
                    nums[j+1] = temp                 
        for i in range(2):
            for j in range(len(nums)-1, i, -1):
                if nums[j] < nums[j-1]:
                    temp = nums[j]
                    nums[j] = nums[j-1]
                    nums[j-1] = temp                      

        return max(nums[0] * nums[1] * nums[-1], nums[-1] * nums[-2] * nums[-3])

        # Solution 2
        import sys
        min1, min2, max1, max2, max3 = sys.maxsize, sys.maxsize, -sys.maxsize, -sys.maxsize, -sys.maxsize
        for i in range(len(nums)):
            if nums[i] < min2:
                if nums[i] < min1:
                    min2 = min1
                    min1 = nums[i]
                else:
                    min2 = nums[i]
            if nums[i] > max1:
                if nums[i] > max3:
                    max1 = max2
                    max2 = max3
                    max3 = nums[i]
                elif nums[i] > max2:
                    max1 = max2
                    max2 = nums[i]
                else:
                    max1 = nums[i]
                
        return max(min1 * min2 * max3, max1 * max2 * max3)


        
       
            
        