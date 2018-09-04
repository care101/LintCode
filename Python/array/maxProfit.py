# -*- coding:UTF-8 -*-
class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        @ Solution:
        - 本题实质就是找到几段连续的递增区域：最大利润就在这几段递增区域的开始和结束时买入卖出；
        - 用flag标记当前所在段是递增还是递减；
        - 要考虑到整个数组都是递增的情况；（code里面的最后一个if）
        """
        profit = 0
        buy_in, sold_out = 0, 0
        flag = 0
        for i in range(len(prices)-1):
            if prices[i] < prices[i+1]:
                if flag != 1:
                    flag = 1
                    buy_in = i
                    
                sold_out = i + 1

            if prices[i] >= prices[i+1] and flag == 1:
                flag = -1           
                profit += prices[sold_out] - prices[buy_in]
                
            if i == len(prices) - 2 and flag == 1:
                profit += prices[sold_out] - prices[buy_in]
            
        return profit
            
        
        