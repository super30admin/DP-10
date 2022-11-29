#312. Burst Balloons
"""
Time Complexity: O(n^3)
Space Complexity: O(n^2)
"""
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        nums_len = len(nums)
        dp = [[0] * (nums_len) for _ in range(nums_len)]
        max_coins = 0
        for l in range(nums_len - 2, 0, -1):
            for r in range(1, nums_len - 1):
                if l <= r:
                    for i in range(l, r + 1):
                        dp[l][r] = max( dp[l][r], nums[l - 1] * nums[i] * nums[r + 1] + dp[l][i - 1] + dp[i + 1][r])
                    max_coins = max(max_coins, dp[l][r])
        return max_coins
