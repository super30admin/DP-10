class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if(nums==None or len(nums)==0):
            return 0
        n=len(nums)
        dp=[[0 for i in range(n)] for i in range(n)]

        for l in range(1,n+1):
            for i in range(n+1-l):
                j = i + l - 1;
                for k in range(i,j+1):
                    leftValue = 1
                    rightValue = 1
                    if (i != 0):
                        leftValue = nums[i-1]
                    if (j != n -1):
                        rightValue = nums[j+1]
                    before = 0
                    after = 0
                    if (i != k): 
                        before = dp[i][k-1]
                    if (j != k):
                        after = dp[k+1][j]

                    dp[i][j] = max(leftValue * nums[k] * rightValue + before + after,dp[i][j])
                    
        return dp[0][n - 1]

    
        