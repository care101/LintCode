class Solution:
    """
    @param triangle: a list of lists of integers
    @return: An integer, minimum path sum
    """
    def minimumTotal(self, triangle):
        # write your code here
        if not triangle: 
            return []
        pathSum = []
        pathSum.append(triangle[0])
        for i in range(1, len(triangle)):
            temp = []
            for j in range(len(triangle[i])):
                if j == 0:
                    temp.append(triangle[i][j] + pathSum[i-1][j])
                elif j == len(triangle[i])-1:
                    temp.append(triangle[i][j] + pathSum[i-1][j-1])
                else:
                    temp.append(triangle[i][j] + min(pathSum[i-1][j], pathSum[i-1][j-1]))
            pathSum.append(temp)
        
        return min(pathSum[-1])
