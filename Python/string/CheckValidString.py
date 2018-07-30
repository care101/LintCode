# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param s: the given string
    @ return: whether this string is valid
    @ solution:
    - 参考：http://www.cnblogs.com/grandyang/p/7617017.html
    - 这边维护两个变量，low_cnt, high_cnt，都用来表示左括号的数量；
    - low_cnt 指在有 ( 的情况下，把 * 当做 ) 时， ( 的数量； high_cnt 指把所有 * 都看做是 ( 时，( 的数量；
    - 遍历字符串，遇到 ( ,二者都加1；遇到 * ，low_cnt大于0时才做减1操作，high_cnt直接加1；遇到 ) 时，low_cnt大于0时才做减1操作，high_cnt直接减1；
    - 判断False情况：遍历完成后，如果high_cnt<0,表明把 * 当 ( 都不够用；如果low_cnt>0，表明 ( 太多； 
    """
    def checkValidString(self, s):
        # Write your code here
        if not s:
            return True
        low_cnt, high_cnt = 0, 0
        for i in range(len(s)):
            if s[i] == '(':
                low_cnt += 1 
                high_cnt += 1 
            if s[i] == ')':
                if low_cnt > 0 : low_cnt -= 1 
                high_cnt -= 1 
            if s[i] == '*':
                if low_cnt > 0 : low_cnt -= 1 
                high_cnt += 1 
                
        if high_cnt < 0 or low_cnt > 0:
            return False
            
        return True
                