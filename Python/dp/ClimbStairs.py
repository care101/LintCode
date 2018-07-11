# -*- coding:UTF-8 -*-
class Solution:
    """
    @ param n: An integer
    @ return: An integer
    @ lsy
    @ 思路：
    - 本质是斐波那契数列；DP；
    - 要达到第i个阶梯，只能由i-1个阶梯直接上去，或者i-2个阶梯跨两步上去，DP方程就是：f(i) = f(i-1) + f(i-2);
    - 初始值：f(1) = 1, f(2) = 2
    """
    def climbStairs(self, n):
        # write your code here
        if n < 3:
            return n 
        steps = [0, 1, 2]
        for i in range(3, n+1):
            steps.append(steps[i-1] + steps[i-2])
       
        return steps[-1]
            
        
