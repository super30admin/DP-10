class Solution:
    def maxCoins(self, A):
        # Time Complexity: O(n**3)
        # Space Complexity: O(n**2)
        A, n = [1] + A + [1], len(A) + 2
        dp = [[0] * n for _ in range(n)]

        for i in range(n - 2, -1, -1):
            for j in range(i + 2, n):
                for k in range(i + 1, j):
                    dp[i][j] = max(dp[i][j], A[i] * A[k] * A[j] + dp[i][k] + dp[k][j])

        return dp[0][n - 1]