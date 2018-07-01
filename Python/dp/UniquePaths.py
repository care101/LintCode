class Solution:
    """
    @param m: positive integer (1 <= m <= 100)
    @param n: positive integer (1 <= n <= 100)
    @return: An integer
    """
    def uniquePaths(self, m, n):
        # write your code here
        if m == 0 and n == 0:
            return 0 
        if m == 0 or n == 0:
            return 1
        path_num = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(m):
            path_num[i][0] = 1 
        for i in range(n):
            path_num[0][i] = 1 
        
        for i in range(1, m):
            for j in range(1, n):
                path_num[i][j] = path_num[i-1][j] + path_num[i][j-1]
        
        return path_num[m-1][n-1]
