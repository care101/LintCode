# -*- coding:UTF-8 -*-
class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        @ Solution:
        - 巧妙的利用异或，任何数与0异或都是本身，两个相同的数异或是0;
        - 异或运算可以交换，可以看成是相同的值先做异或运算，变成0，最后再做单独数值的异或；
        """
        a = 0
        for c in nums:
            a ^= c
        return a