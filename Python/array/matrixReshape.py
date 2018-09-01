class Solution:
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        m, n = len(nums), len(nums[0])
        if m * n != r * c:
            return nums
        
        B = []
        p, q = 0, 0
        for i in range(r):
            temp = []
            while p*n + q < (i+1)*c:
                if q == n:
                    p, q = p+1, 0
                temp.append(nums[p][q])
                q = q+1
            B.append(temp)
        
        return B
        