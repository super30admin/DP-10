# TC:O(n * k)
# SC:O(n* k)

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        if n == 0:
            return 0

        dp = [[0] * (k + 1) for i in range(n + 1)]
        print(dp)

        attempt = 0

        while dp[attempt][k] < n:
            attempt += 1
            for i in range(1, k + 1):
                dp[attempt][i] = 1 + dp[attempt - 1][i - 1] + dp[attempt - 1][i]

        return attempt
