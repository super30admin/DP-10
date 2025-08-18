# Time Complexity: O(n^3)
# Space Complexity: O(n^2)

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0]*n for _ in range(n)]

        for le in range(1, n + 1):
            for i in range(n - le + 1):
                j = i + le - 1
                for k in range(i, j + 1):
                    before = dp[i][k - 1] if i != k else 0
                    after = dp[k + 1][j] if j != k else 0

                    prev = nums[i - 1] if i > 0 else 1
                    next = nums[j + 1] if j < n - 1 else 1

                    balloonItself = prev * nums[k] * next

                    dp[i][j] = max(dp[i][j], before + balloonItself + after)

        return dp[0][n - 1]
