""""// Time Complexity : O(n*k)
// Space Complexity :O(n*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        attempts = 0
        dp = [[0 for i in range(k + 1)] for j in range(n + 1)]
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k + 1):
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j]
        return attempts


""""// Time Complexity : O(n^3)
// Space Complexity :O(m*n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def superEggDrop(self, k: int, n: int) -> int:
#         dp=[[0 for i in range(n+1)] for j in range(k+1)]

#         for j in range(0, n+1):
#             dp[1][j]=j

#         for i in range(2, k+1):
#             for j in range(1, n+1):
#                 dp[i][j]=float('inf')
#                 for f in range(1, j+1):
#                     dp[i][j]=min(dp[i][j], 1+max(dp[i-1][f-1], dp[i][j-f]))

#         return dp[k][n]