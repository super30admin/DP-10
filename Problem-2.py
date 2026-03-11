# Time Complexity : O(N^3)  # DP over all intervals and last burst balloon
# Space Complexity : O(N^2) # DP table for intervals
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# We treat each balloon as the last one to burst within an interval.
# Coins gained depend on left and right boundaries.
# DP stores the maximum coins obtainable for each interval.

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0]*n for _ in range(n)]

        for length in range(2,n):
            for left in range(n-length):
                right = left + length
                for k in range(left+1,right):
                    coins = nums[left]*nums[k]*nums[right]
                    coins += dp[left][k] + dp[k][right]
                    dp[left][right] = max(dp[left][right], coins)

        return dp[0][n-1]