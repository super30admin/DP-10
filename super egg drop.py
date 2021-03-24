"""
Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
use DP since there is repeated subproblem
make matrix of floors vs eggs
start from 1 egg and 1 floor
take two cases 1. if breaks 
                2. if no break
that can be written as :  1 + max(dp[eggs left][floors need to be checked], fp[eggs][floors])
                           |  if egg breaks                         |    if no break    |
to get value of eggs and floor we use the index i and j of dp array       

"""

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:    
    # def superEggDrop(self, K: int, N: int) -> int:

        # rows - k
        # cols - n
        allowed = 0
        dp = [[0]*(k+1) for _ in range(n+1)]
        
        while dp[allowed][k] < n:
            allowed += 1
            for j in range(1, k+1):
                dp[allowed][j] = 1+dp[allowed-1][j-1] +dp[allowed-1][j]
            
        return allowed
        
        
        
        
        
        
        
        
#         dp = [[0]*(n+1) for _ in range(k+1)]
        
#         for i in range(1, n+1):
#             dp[1][i] = i
            
#         for i in range(2, k+1):
#             for j in range(1, n+1):
#                 dp[i][j] = float('inf')
#                 for floor in range(1,j+1):
#                     dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][floor - 1], dp[i][j - floor])) 
#         print(dp)        
#         return dp[-1][-1]
        
        
        