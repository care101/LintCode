class Solution:
    """
    @param str: str: the given string
    @return: char: the first unique character in a given string
    """
    def firstUniqChar(self, str):
        # Write your code here
        a_num = ord('a')
        letter_count = [0 for i in range(26)]
        for i in range(len(str)):
            num = ord(str[i]) - a_num
            letter_count[num] += 1 
        
        for i in range(26):
            if letter_count[i] == 1:
                return chr(a_num+i)
