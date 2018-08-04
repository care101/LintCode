class Solution:
    """
    @param num: a positive number
    @return: true if it's a palindrome or false
    """
    def isPalindrome(self, num):
        # write your code here
        list1 = []
        while num:
            list1.append(num%10)
            num = int(num/10)
            
        i, j = 0, len(list1)-1
        while i < j:
            if list1[i] != list1[j]:
                return False
            i, j = i+1, j-1
            
        return True
