# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param nums: A list of integer which is 0, 1 or 2 
    @ return: nothing
    @ solution: 
    - 对数组nums在最左和最右分别划分一个0区和一个2区，设置两个变量zero_interval, two_interval分别表示两个区域的位置；
    - 遍历数组，当发现是0时，与0区1前一个数交换，当发现是2时，与2区前一个数交换；
    - 注意当遍历到2时，下标i不做加1处理，因为2区的数字没有遍历过，不知道是什么数值；
    - 注意zero_interval, two_interval的初始值；
    """
    def swap(self, a, b):
        temp = a 
        a = b 
        b = temp
        return a, b
    
    def sortColors(self, nums):
        # write your code here
        if not nums:
            return nums
            
        zero_interval, two_interval = -1, len(nums)
        i = 0
        while i < two_interval:
            if nums[i] == 0:
                zero_interval += 1 
                nums[i], nums[zero_interval] = self.swap(nums[i], nums[zero_interval])
                i += 1 
            elif nums[i] == 2:
                two_interval -= 1 
                nums[i], nums[two_interval] = self.swap(nums[i], nums[two_interval])
            else:
                i += 1 
        return nums
                
