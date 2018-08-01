class Solution:
    """
    @ param A: an integer array
    @ return: nothing
    """
    def sortIntegers(self, A):
        # write your code here        

        for i in range(len(A)-1):
            for j in range(i, -1, -1):
                if A[j+1] < A[j]:
                    temp = A[j]
                    A[j] = A[j+1]
                    A[j+1] = temp
                else:
                    break               
        return A