"""
Time Complexity : O(n^3)
Space Complexity : O(n^2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
For this approach, we have to calculate value for all possible combinations as order matters here a lot, and would be 
using DP for that. For a particular cell or subproblem, we calculate max of all possible combinations of a particular length,
keeping left max value and right max value as 1 if out of bounds on the corresponding sides.
"""


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if (nums == None or len(nums) == 0):
            return 0
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        for length in range(2, n):
            for i in range(0, n - length):
                j = i + length
                for k in range(i+1, j):
                    before, after = dp[i][k], dp[k][j]
                    leftVal, rightVal = nums[i], nums[j]
                    curr = before + (leftVal * nums[k] * rightVal) + after
                    dp[i][j] = max(dp[i][j], curr)
        return dp[0][n - 1]
