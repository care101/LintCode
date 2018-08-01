class Solution:
    """
    @ param A: an integer array
    @ return: nothing
    """
    def sortIntegers(self, A):
        # write your code here        

        for i in range(len(A)-1):
            for j in range(len(A)-i-1):
                if A[j] > A[j+1]:
                    temp = A[j]
                    A[j] = A[j+1]
                    A[j+1] = temp
        return A
        
