"""
Time Complexity : O(n^2)
Space Complexity : O(n(2))
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
go from bottom up
first take length == 1 of array and calculate cost
finally return the dp[0][n-1]


"""

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        n = len(nums)
        dp = [[0]*n for i in range(n)]
        for ln in range(1, n+1):
            for i in range(n-ln+1):
                j = i + ln -1
                for k in range(i,j+1):
                    leftVal = 1
                    rightVal = 1
                    #leftVal
                    if i != 0:
                        leftVal = nums[i-1]
                    
                    #rightVal
                    if j !=n-1:
                        rightVal = nums[j+1]
                    before, after = 0,0
                    
                    #before
                    if k != i:
                        before = dp[i][k-1]
                    
                    #after
                    if k != j:
                        after = dp[k+1][j]
                    dp[i][j] = max(dp[i][j], before + leftVal*nums[k]*rightVal + after)
        return dp[0][n-1]
       