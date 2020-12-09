class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n==0:
            return 0

        # dp will store the results of our calls
        dp = [[0] * n for _ in range(n)]
        
        for i in range(1,n+1):
            for left in range(0,n-i+1):
                right = left +i -1
                for last in range(left,right+1):
                    leftval = 1
                    rightval = 1
                    if left!=0:
                        leftval = nums[left-1]
                    
                    if right!=n-1:
                        rightval = nums[right+1]
                        
                    beforewindow = 0
                    afterwindow = 0
                    if left!=last:
                        beforewindow = dp[left][last-1]
                    if right!=last:
                        afterwindow = dp[last+1][right]
                    
                    dp[left][right]=max(dp[left][right],beforewindow+afterwindow+nums[last]*leftval*rightval)
                    
        return dp[0][n-1]
                
                #tc o(n^3)
                @sc = o(n^2)
