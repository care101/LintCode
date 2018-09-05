class Solution:
    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        group = []
        start, end = 0, 0 
        for i in range(1, len(S)):
            if S[i] == S[start]:
                end = i
                if i == len(S)-1 and end - start >= 2:
                    group.append([start, end])
            else:
                if end - start >= 2:
                    group.append([start, end])
                start, end = i, i
        return group
            
        