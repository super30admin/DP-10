# TC - O(n * k)
# SC - O(n * k)

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        if k == 0 or n == 0: return 0
        dp = [[0 for i in range(k + 1)] for i in range(n + 1)]
        attempts = 0

        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k + 1):
                dp[attempts][j] = 1 + (dp[attempts - 1][j - 1] + dp[attempts - 1][j])
        return attempts