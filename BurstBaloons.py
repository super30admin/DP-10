-------------------------Max Coins------------------------------------------
# Time Complexity : O(N**3) N is the length of the nums 
# Space Complexity : O(N**2)  No extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will take the windows of size 1 to len(nums) and calculate the before and after sum by iterating through 
# array and assuming that will be the end element. We will have left , right and the product element if the baloon burrsts
# the temp result will be stored in dp array and reused when before and after element is already calculated. we will get the 
# end result once we calculate the entire length matrix window.

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        
        n = len(nums)
        dp = [[0 for i in range(n)] for j in range(n)]
        for l in range(1,n+1):
            for i in range(n-l+1):
                j = i+l-1
                for k in range(i,j+1):
                    left = 1
                    right = 1
                    
                    if i != 0:
                        left = nums[i-1]
                    if j != n-1:
                        right = nums[j+1]
                    
                    after = 0
                    before = 0
                    
                    if k != 0:
                        before = dp[i][k-1]
                    if k != n-1:
                        after = dp[k+1][j]
                    
                    dp[i][j] = max(dp[i][j], before+left*nums[k]*right+after)
        return dp[0][n-1]