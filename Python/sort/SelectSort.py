class Solution:
    """
    @ param A: an integer array
    @ return: nothing
    """
    def sortIntegers(self, A):
        # write your code here        

        for i in range(len(A)-1):
            min_val = A[i]
            temp = i 
            for j in range(i, len(A)-1):
                if min_val > A[j+1]:
                    min_val = A[j+1]
                    temp = j + 1
            A[temp] = A[i]
            A[i] = min_val  
        return A
        