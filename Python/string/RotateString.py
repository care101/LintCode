# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param str: An array of char
    @ param offset: An integer
    @ return: nothing
    @ 说明：
    - 这道题是2018.8.2做的，感觉LeetCode这题有点问题，代码中注释的部分在自己电脑上，测试题是通过的；
    - 另一个问题就是Python的string是不可修改的，也就是说我这边reverse代码里的赋值修改是有问题的；
        - 如果要对string进行修改，只能间接修改，可以先把他变成list，最后在用join给连接起来；
    """
    def reverse(self, s, start, end):
        while start < end:
            temp = s[start]
            s[start] = s[end]
            s[end] = temp
            start += 1
            end -= 1
        return s
            
    
    def rotateString(self, str, offset):
        # write your code here

        # offset = offset % len(str)
        # str = str[-offset : ] + str[0 : len(str)-offset]
        # return str

        if not str:
            return str 
        length = len(str)
        if offset > length:
            offset = offset % length
        str = self.reverse(str, 0, length-offset-1)
        str = self.reverse(str, length-offset, length-1)
        str = self.reverse(str, 0, length-1)
        return str
            
        