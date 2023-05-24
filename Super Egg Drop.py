class Solution:
    # time O(nk)
    # Space O(nk)
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for i in range(k+1)] for j in range(n+1)]
        # print(dp)
        attempts = 0
        while(dp[attempts][k] < n):
            attempts += 1
            for j in range(1, k+1):
                dp[attempts][j] = 1 + dp[attempts - 1][j-1] + dp[attempts - 1][j]

        return attempts