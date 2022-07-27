# Time Complexity : O(N^3) where N is number of balloons
# Space Complexity : O(N^2) where N is number of balloons
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0: return 0
        
        dp = [[0 for _ in range(n)] for _ in range(n)]
        
        for l in range(1, n+1):
            for i in range(0, n-l + 1):
                j = i + l - 1
                dp[i][j] = float('-inf')
                for k in range(i, j+1):
                    before = 0
                    if i != k:
                        before = dp[i][k-1]
                    
                    after = 0
                    if j != k:
                        after = dp[k+1][j]
                                    
                    left = 1
                    if i != 0:
                        left = nums[i-1]
                    
                    right = 1
                    if j != n-1:
                        right = nums[j + 1]
                    
                    dp[i][j] = max(dp[i][j], before + left * nums[k] * right + after)
        
        return dp[0][n-1]