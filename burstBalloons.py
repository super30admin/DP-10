#TC : O(n^3)
#SC : O(n^2)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0]*n for _ in range(n)]
        for le in range(1,n+1):
            for i in range(n-le+1):
                for j in range(i, i+le):
                    left = right = 0
                    here = nums[j]
                    if j-1>=0:
                        left = dp[i][j-1]
                    
                    if i-1>=0:
                        here*=nums[i-1]
                    
                    if j+1<n:
                        right = dp[j+1][i+le-1]
                    
                    if i+le<n:
                        here*=nums[i+le]
                    
                    points = left + here + right

                    dp[i][i+le-1] = max(dp[i][i+le-1], points)
        
        return dp[0][n-1]


