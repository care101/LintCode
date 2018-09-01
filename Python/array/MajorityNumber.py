# -*- coding:UTF-8 -*-
class Solution:
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        @ Solution 1:
        - 使用一个字典来存放对应数字出现的次数，最后再遍历字典，找到出现次数大于n/2的数字；
        - 时间复杂度：O(n)， 空间复杂度：额外使用一个字典，O(n);
        @ Solution 2:
        - 定义两个变量ans和count，用来存放当前出现次数多的数值和出现次数；
        - 遍历数组，如果数值与ans不同，并且count>0,对count减1，若count已经为0，则更换ans为当前值，并count赋1；如果数值与ans相同，count加1；
        - 最后的ans就是出现次数超过n/2的值；
        - 时间复杂度：O(n), 空间复杂度：额外使用两个变量，O(1);
        """
        # Solution 1
        num_times = {}
        for i in range(len(nums)):
            temp = nums[i]
            if temp in num_times:
                num_times[temp] += 1
            else:
                num_times[temp] = 1
                
        for name in num_times.keys():
            if num_times[name] > len(nums)/2:
                return name

        
        # Solution 2
        ans, count = nums[0], 1
        for i in range(1, len(nums)):
            if nums[i] != ans:
                if count == 0:
                    ans, count = nums[i], 1
                else:
                    count -= 1
            else:
                count += 1
        return ans
               