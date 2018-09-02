# -*- coding:UTF-8 -*-
class Solution:
    '''
    @ Solution:
    - 找出所有island的面积，用max_area来存放目前为止最大的面积；
    - 每个island的面积计算：当碰到1的时候，把对应的位置坐标放入栈内，同时把该位置置为-1；
    - 依次出栈，找出这个位置坐标的四周是否存在1，存在则继续把位置坐标加入栈内；
    - 最后要复原这个数组，把之前标为-1的位置改回原来的1；
    '''
    def areaOfIsland(self, grid, i, j):
        stack = [(i, j)]
        grid[i][j] = -1
        area = 1
        pos_i = [0, 0, 1, -1]
        pos_j = [1, -1, 0, 0]
        while stack:
            i, j = stack.pop()
            for n in range(4):
                temp_i, temp_j = i + pos_i[n], j + pos_j[n]
                if 0 <= temp_i < len(grid) and 0 <= temp_j < len(grid[0]) and grid[temp_i][temp_j] == 1:
                    stack.append((temp_i, temp_j))
                    grid[temp_i][temp_j] = -1
                    area += 1
        return area
    
    
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        m, n = len(grid), len(grid[0])
        area, max_area = 0, 0 
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = self.areaOfIsland(grid, i, j)
                if max_area < area:
                    max_area = area
                    
        for i in range(m):
            for j in range(n):
                if grid[i][j] == -1:
                    grid[i][j] = 0
                    
        return max_area
                                      