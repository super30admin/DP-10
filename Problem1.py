# Problem 1: Super Egg Drop
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        attempts = 0
        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]

        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1,k+1):
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j]

        return attempts
        