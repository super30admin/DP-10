"""
Time Complexity : O(n^3) where n is the length of nums
Space Complexity : O(n^2) where n is the length of nums
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        n = len(nums)
        dp = [[0 for j in range(n + 1)] for _ in range(n)]
        # We reference the dp table each time we compute the no. of coins and store
        # the left, right, after and before. At the end we just do the calculations
        # and store it in the table
        for leng in range(1, n+1):
            for i in range(n - leng + 1):
                j = i + leng - 1
                for k in range(i, j + 1):
                    left = 1
                    right = 1
                    if i != 0:
                        left = nums[i - 1]
                    if j != n - 1:
                        right = nums[j + 1]
                    before = 0
                    after = 0
                    if k != i:
                        before = dp[i][k - 1]
                    if k != j:
                        after = dp[k + 1][j]
                    dp[i][j] = max(dp[i][j], before + (left * nums[k] * right) + after)
        return dp[0][n - 1]
                