# -*- coding:UTF-8 -*-
'''
思路：
    'O'不能变成'X'的情况只有一种，就是当这片连通域中存在边界点的时候，所以可以考虑只从边界点出发去寻找；
    边界点中有'O'的，找出与他相连的区域，标记为'F'；(利用栈/队列)
    边界全部查找结束后，把矩阵中还是'O'的标记为'X'；然后再把矩阵中的'F'还原为'O'.
'''
class Solution:
    """
    @param: board: board a 2D board containing 'X' and 'O'
    @return: nothing
    """
    def mark(self, i, j, board, row, col):
        i_cor = [-1, 0, 0, 1]
        j_cor = [0, -1, 1, 0]
        q = []
        q.append((i,j))
        while q:
            temp = q.pop()
            i, j = temp[0], temp[1]
            board[i][j] = 'F'
            for n in range(4):
                temp_i, temp_j = i+i_cor[n], j+j_cor[n]
                if temp_i >= 0 and temp_i < row-1 and temp_j >= 0 and temp_j < col-1 and board[temp_i][temp_j] == 'O':
                    q.append((temp_i, temp_j))
                    board[temp_i][temp_j] = 'F'
                
    
    def surroundedRegions(self, board):
        # write your code here
        if len(board) == 0:
            return []
        row, col = len(board), len(board[0])
        i_cor, j_cor = [0, row-1], [0, col-1]
        for i in range(row):
            for n in range (2):
                j = j_cor[n]
                if board[i][j] == 'O':
                    self.mark(i, j, board, row, col)

        for j in range(1, col-1):
            for n in range (2):
                i = i_cor[n]
                if board[i][j] == 'O':
                    self.mark(i, j, board, row, col)
                    
        for i in range(row):
            for j in range(col):
                if board[i][j] == 'O':
                    board[i][j] = 'X'

        for i in range(row):
            for j in range(col):
                if board[i][j] == 'F':
                    board[i][j] = 'O'  
                    
        return board
                
