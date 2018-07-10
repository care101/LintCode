class Solution:
    """
    @param n: an integer
    @return: an ineger f(n)
    """
    def fibonacci(self, n):
        # write your code here
        if n < 3:
            return n - 1 
        fib_arr = [0, 0, 1]
        for i in range(3, n+1):
            fib_arr.append(fib_arr[i-1] + fib_arr[i-2])
        
        return fib_arr[-1]
        
        
