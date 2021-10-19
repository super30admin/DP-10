"""
Time Complexity : O(k*n) where n is the no. of floors and k is the no. of eggs
Space Complexity : O(k*n) where n is the no. of floors and k is the no. of eggs
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        if n == 0:
            return 0
        dp = [[0]*(k+1) for i in range(n+1)]
        attempts = 0
        # We compute for each no. of eggs the no. of attemtps are required to compute 
        # the minimum no. of moves. Whenever the no. of attempts for particular no eggs
        # increase than the no. of floors we stop and return the attempts.
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k + 1):
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j]
        return attempts