# Time Complexity : O(N^3)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        #can do backtracking..this dp is O(n^3)
        if not nums:
            return 0
        
        n = len(nums)
        dp = [[0 for i in range(n)] for i in range(n)]
        for length in range(1, n+1):
            for i in range(n+1-length):
                j = i + length - 1
                for k in range(i, j + 1):
                    left = 1
                    right = 1 
                    if i != 0:
                        left = nums[i-1]
                    if j != n-1:
                        right = nums[j+1]
                    before = 0
                    after = 0
                    if i != k:
                        before = dp[i][k-1]
                    if j != k:
                        after = dp[k+1][j]
                    
                    dp[i][j] = max(dp[i][j], before + left*nums[k]*right + after)
                    
        return dp[0][-1]