# TC:O(n^3)
# SC:O(n^2)

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        n = len(nums)
        dp = [[0] * n for i in range(n)]

        for l in range(1, n + 1):
            for i in range(0, n - l + 1):
                j = i + l - 1
                for k in range(i, j + 1):
                    before = 0
                    after = 0

                    if k != i:
                        before = dp[i][k - 1]

                    if k != j:
                        after = dp[k + 1][j]

                    left = 1
                    right = 1

                    if i != 0:
                        left = nums[i - 1]

                    if j != n - 1:
                        right = nums[j + 1]

                    dp[i][j] = max(dp[i][j], before + left * nums[k] * right + after)

        return dp[0][-1]


