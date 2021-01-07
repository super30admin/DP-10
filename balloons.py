# As taught in class using DP to solve this probleem. Create and array for considering window and then suppose for array [2,3,4,5] we have window of [2,3] put values in dp array when 2 is burst, before 2 there is 0 ftere 2 there is 3.
# Time Compleexity: O(n^3)
# Space Complexity: O(m*n)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if nums is None or len(nums):
            return 0
        n = len(nums)
        dp = [[0]*n]*n
        print(dp)
        for leng in range(1,n):
            for i in range(n-leng):
                j = i + leng - 1
                for k in range(i,j):
                    leftval = 1
                    rightval = 1
                    if (i!=0):
                        leftval = nums[i-1]
                    if j != n - 1:
                        rightval = nums[j+1]
                    before = 0
                    after = 0
                    if (k != 0):
                        before = dp[i][k-1]
                    if (k != n-1):
                        after = dp[k+1][j]
                    dp[i][j] = max(dp[i][j], before + leftval*nums[k]*rightval + after)
        return dp[0][n-1]