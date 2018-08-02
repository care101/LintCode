# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param str: a string
    @ return: return a string
    @ solution:
    - 先把整个字符串全部倒过来，然后再把单独的单词倒过来即可；(需要一个把字符串逆转的函数;)
    - 或者利用python 自带的string函数，split，join;
    """
    def reverseChar(self, a, start, end):
        i, j = start, end
        while i < j:
            temp = a[i]
            a[i] = a[j]
            a[j] = temp
            i, j = i+1, j-1
        return a 
    
    
    def reverseWords(self, str):
        # write your code here
        if not str:
            return str
        str2 = list(str)
        str2 = self.reverseChar(str2, 0, len(str2)-1)
        left, right = 0, 0
        while right < len(str2):
            if str2[right] == ' ':
                str2 = self.reverseChar(str2, left, right-1)
                right += 1 
                left = right 
            else:
                right += 1 
            if right == len(str2)-1:
                str2 = self.reverseChar(str2, left, right)
        str2 = ''.join(str2)
        return str2

        # if not str:
        #     return str
        # return ' '.join(str.split(' ')[::-1])