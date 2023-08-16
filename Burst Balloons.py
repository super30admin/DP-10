# Time Complexity : O(n^3)
# Space Complexity : O(n^2)
# Code ran on LeetCode
# Calculate the maximum coins possible for each subinterval of balloons and store the results in a dynamic programming table (dp). The maximum coins are updated by considering the left, right, and burst values for each possible position of the last balloon burst in the interval. 

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for l in range(1, n+1):
            for i in range(n-l + 1):
                j = i + l - 1
                res = float('-inf')
                for k in range(i, j+1):
                    # k th balloon bursting in the end
                    left = right = 0
                    if k > i:
                        left = dp[i][k-1]
                    if k < j:
                        right = dp[k+1][j]
                    
                    before = after = 1
                    if i != 0:
                        before = nums[i-1]
                    if j != n-1:
                        after = nums[j+1]
                    
                    res = max(res, left + before*nums[k]*after + right)
                dp[i][j] = res

        return dp[0][n-1]
                