# Time Complexity : O(N^3)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums:
            return None
        n = len(nums)
        dp = [[0 for j in range(n + 1)] for i in range(n + 1)]

        for leng in range(1, n + 1):
            for i in range(n - leng + 1):
                # i and j are decision making array
                j = i + leng - 1
                for k in range(i, j + 1):
                    #k for determining which balloons to burst in the end
                    left = 1
                    right = 1
                    if i != 0:
                        left = nums[i - 1]
                    if j != n - 1:
                        right = nums[j + 1]
                    before = 0
                    after = 0
                    if i != k:
                        before = dp[i][k - 1]
                    if j != k:
                        after = dp[k + 1][j]
                    dp[i][j] = max(dp[i][j],
                                   before + (left * nums[k] * right) + after)

        return dp[0][n - 1]
