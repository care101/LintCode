# -*- coding:UTF-8 -*-
class Solution:
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        @ Solution:
        - 只有三种情况：0,11,10,实际上是走一步还是走两步的问题；
        - 假设当前在第i个位置，如果这个位置的值为0，则i往后走一步，否则往后走两步；
        """
        i = 0
        while i < len(bits)-1:
            if bits[i] == 0:
                i += 1
            else:
                i += 2
        return i == len(bits)-1
        