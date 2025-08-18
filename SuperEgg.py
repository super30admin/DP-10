# Time Complexity: O(n*k)
# Space Complexxity: O(n*k)
# Approach
# Dp to check max floors with i attempts and j eggs
# Formula: 1 + below + above to get the new range
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (k+1) for _ in range(n+1)]
        attempts = 0
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k+1):
                dp[attempts][j] = 1 + dp[attempts - 1][j - 1] + dp[attempts - 1][j]
        return attempts