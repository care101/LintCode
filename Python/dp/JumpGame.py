class Solution:
    """
    @param A: A list of integers
    @return: A boolean
    """
    
    def canJumpFromPosition(self, A, pos):
        if A[pos] + pos >= len(A)-1:
            return True
        else:
            temp = False
            for i in range(1, A[pos]+1):
                temp = temp or self.canJumpFromPosition(A, pos+i)
            return temp
    
    
    def canJump(self, A):
        # write your code here
        
        # Solution 1: recursion
        return self.canJumpFromPosition(A, 0)

        # Solution 2: DP
        canJumpFromPos = [False for i in range(len(A))]
        canJumpFromPos[-1] = True
        for pos in range(len(A)-2, -1, -1):
            if A[pos] + pos > len(A):
                canJumpFromPos[pos] = True
            else:
                temp = False
                for i in range(pos+1, pos+1+A[pos]):
                    temp = temp or canJumpFromPos[i]
                canJumpFromPos[pos] = temp
        return canJumpFromPos[0]
            
            
        
