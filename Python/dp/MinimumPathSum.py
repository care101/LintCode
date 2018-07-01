class Solution:
    """
    @param grid: a list of lists of integers
    @return: An integer, minimizes the sum of all numbers along its path
    """

    def minPathSum(self, grid):
        # write your code here
        row, col = len(grid), len(grid[0])
        path_cost = [[0 for i in range(col)] for j in range(row)]
       
        path_cost[0][0] = grid[0][0]
        for i in range(1, row):
            path_cost[i][0] = grid[i][0] + path_cost[i-1][0]
        for i in range(1, col):
            path_cost[0][i] = grid[0][i] + path_cost[0][i-1]
            
        for i in range(1, row):
            for j in range(1, col):
                path_cost[i][j] = grid[i][j] + min(path_cost[i-1][j], path_cost[i][j-1])
        
        return path_cost[row-1][col-1]