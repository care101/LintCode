class Solution:
    def flipReverse(self, a):
        p, q = 0, len(a)-1
        while p < q:
            temp = a[p] ^ 1
            a[p] = a[q] ^ 1
            a[q] = temp
            p, q = p+1, q-1
        if p == q:
            a[p] ^= 1
        return a
    
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        for i in range(len(A)):
            A[i] = self.flipReverse(A[i])
        
        return A
                