class Solution:
    """
    @param numbers: An array of Integer
    @param target: target = numbers[index1] + numbers[index2]
    @return: [index1, index2] (index1 < index2)
    """
    # Hash map
    def twoSum(self, numbers, target):
        # write your code here
        dict_ = {}
        for i in range(len(numbers)):
            idx = dict_.get(target-numbers[i])
            if idx == None:
                temp = numbers[i]
                dict_[temp] = i
            else:
                return [idx, i]
        return False