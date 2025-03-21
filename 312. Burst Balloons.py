#time:O(n*n)
#space:O(n*n)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n=len(nums)
        if n==0:
            return 0
        
        dp=[[0 for _ in range(n+1)]for _ in range(n+1)]

        for lnth in range(1,n+1):
            for i in range(n-lnth+1):
                j= lnth+i -1
                for k in range(i,j+1):
                    left=1
                    if(i!=0):
                        left=nums[i-1]
                    right=1
                    if j!=n-1:
                        right= nums[j+1]
                    before=0
                    if k!=i :
                        before=dp[i][k-1] 
                    after=0
                    if k!=j:
                        after=dp[k+1][j]
                    dp[i][j]=max(dp[i][j], before+ left*nums[k]*right +after) 
        return dp[0][n-1]

    
