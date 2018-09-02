class Solution:
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        m, n = len(A), len(A[0])
        B = []
        for j in range(n):
            temp = [A[i][j] for i in range(m)]
            B.append(temp)
        return B
        