class Solution:
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        num_dict = {}
        for c in nums:
            if c in num_dict.keys():
                return True
            else:
                num_dict[c] = 1
        return False