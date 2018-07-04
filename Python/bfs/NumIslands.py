 class Solution:
    """
    @param grid: a boolean 2D matrix
    @return: an integer
    """
    def mark(self, i, j, grid, row, col):
      i_cor = [1, -1, 0, 0]
      j_cor = [0, 0, 1, -1]
      q = []
      q.append((i,j))
      while q:
        temp = q.pop()
        i = temp[0]
        j = temp[1]
        grid[i][j] = 0
        for n in range(4):
          temp_i = i + i_cor[n]
          temp_j = j + j_cor[n]
          if temp_i >= 0 and temp_i < row and temp_j >= 0 and temp_j < col:
            if grid[temp_i][temp_j]:
              q.append((temp_i, temp_j))
              grid[temp_i][temp_j] = 0
            
    def numIslands(self, grid):
        # write your code here
        if not grid:
          return 0
        row = len(grid)
        col = len(grid[0])
        count = 0
        for i in range(row):
          for j in range(col):
            if grid[i][j]:
              self.mark(i, j, grid, row, col)
              count += 1
        return count
    

          
          
        
