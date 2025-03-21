from typing import List

class Solution:
    # TC : O(n**3)
    # SC : O(n**2)
    def maxCoins(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        nums = [1] + nums + [1]  # Add virtual balloons at the boundaries
        n = len(nums)
        dp = [[0] * n for _ in range(n)]
        
        for length in range(1, n - 1):  # Length of the subarray
            for i in range(1, n - length):  # Start index
                j = i + length - 1  # End index
                for k in range(i, j + 1):  # Choosing the last balloon to burst
                    dp[i][j] = max(dp[i][j], 
                                   dp[i][k - 1] + nums[i - 1] * nums[k] * nums[j + 1] + dp[k + 1][j])
        
        return dp[1][n - 2]  # The range [1, n-2] corresponds to the original list
