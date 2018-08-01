class Solution:
    """
    @ param A: an integer array
    @ return: nothing
    """
    def merge(self, A, start, end):
        mid = int((start+end)/2)
        i, j = start, mid+1 
        B = []
        while i <= mid and j <= end:
            if A[i] < A[j]: 
                B.append(A[i])              
                i += 1 
            else:
                B.append(A[j])
                j += 1 
        while i <= mid:
            B.append(A[i])
            i += 1 
        while j <= end:
            B.append(A[j])
            j += 1  
        for i in range(len(B)):      # notice duplicate B to A, A should start from index start, not from index 0
            A[start] = B[i]  
            start += 1      
        return A
        
    def mergeSort(self, A, start, end):
        if start >= end:
            return A 
        mid = int((start+end)/2)
        A = self.mergeSort(A, start, mid)
        A = self.mergeSort(A, mid+1, end)
        A = self.merge(A, start, end)
        return A
        
    
    def sortIntegers(self, A):
        # write your code here
        return self.mergeSort(A, 0, len(A)-1)