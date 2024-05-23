# Time Complexity : O(n^3)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0]*n for _ in range(n)]

        for l in range(1, n+1):
            #possible start index of burstible arr
            for i in range(0, n-l+1):
                j = i+l-1
                maxVal = 0
                for k in range(i, j+1):
                    #kth balloon at the end
                    #before + left * kth balloon * right + after
                    before = 0
                    if(i != k):
                        before = dp[i][k-1]
                    after = 0
                    if(j != k):
                        after = dp[k+1][j]
                    left = 1
                    if(i != 0):
                        left = nums[i-1]
                    right = 1
                    if(j != n-1):
                        right = nums[j+1]
                    maxVal = max(maxVal, before + left * nums[k] * right + after)
                dp[i][j] = maxVal
            
        return dp[0][n-1]