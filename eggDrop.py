"""
DP 2D array approach (time limit exceeded) rows = eggs, col = floors-
TC - O(kn^2)
SC - O(k * n)

DP 2D array optimized approach rows = attempts (floors) , col = eggs-
TC - O(n * k)
SC - O(n * k)
"""
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        if k == 0 or n == 0: return 0

        # rows = attempts (floors)
        # cols = eggs
        dp = [[0 for i in range(k + 1)] for i in range(n + 1)]
        # print(dp)

        attempts = 0

        # we increment attempts till we reach n+1
        # as soon as we reach n+1, we return the row (attempt number i.e. floor number)
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k + 1):
                dp[attempts][j] = 1 + (dp[attempts - 1][j - 1] + dp[attempts - 1][j])
        return attempts