class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start, end = 0, len(nums)-1
        while start <= end:
            mid = int((start+end)/2)
            if target < nums[mid]:
                end = mid - 1
            elif target > nums[mid]:
                start = mid + 1
            else:
                return mid
        return -1
        