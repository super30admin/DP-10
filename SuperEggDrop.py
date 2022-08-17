# Time Complexity : O(n*k)
# Space Complexity : O(n*k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = []
        for i in range(n+1):
            dp.append([0]*(k+1))
        for i in range(1, n+1):
            for j in range(1, k+1):
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j]
                if dp[i][j] >= n:
                    return i


print(Solution().superEggDrop(2, 6))


# TLE
# TC: O(n^3); SC: O(m*n)
# import sys
#
#
# class Solution:
#     def superEggDrop(self, k: int, n: int) -> int:
#         dp = [[sys.maxsize]*(n+1)]
#         dp[0][0] = 0
#         for i in range(k):
#             dp.append([0]*(n+1))
#         for e in range(1, k+1):
#             for f in range(1, n+1):
#                 mini = sys.maxsize
#                 for i in range(1, f+1):
#                     mini = min(mini, 1+max(dp[e-1][i-1], dp[e][f-i]))
#                 dp[e][f] = mini
#         return dp[k][n]
#
#
# print(Solution().superEggDrop(2, 6))
