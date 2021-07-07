'''
312. Burst Balloons
Time complexity - O(N^3)
space complexity -O(N^2)
Approach - DP
          1) at each subsequence we need to calculate before number of balloons got bursted and after number of balloons got bursted
          2) In the middle simply we multiply the first right and first left of part of element  outside the subsequence which are not bursted 
          3) In the end we return dp[0][n-1]
'''
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        if not nums: return 0
        
        n=len(nums)
        dp =[[0 for _ in range (n)] for _ in range(n)]
        for len1 in range(1,n+1):
            for i in range(0,n-len1+1):
                j=i+len1-1
                for k in range(i,j+1):
                    
                    #middle part of subsequence
                    
                    left_val=1
                    right_val=1
                    if (i!=0):
                        left_val=nums[i-1]
                    if (j!=n-1):
                        right_val =nums[j+1]
                        
                        
                    # before and after for a subsequence - number of ballons bursted with in the sub for L/R
                    before=0
                    after=0
                    
                    if (i!=k): # before part
                        before =dp[i][k-1]
                        
                    if (j!=k): #after part
                        after =dp[k+1][j]
                    
                    dp[i][j]=max(dp[i][j],before + left_val*nums[k]*right_val + after)
        return dp[0][n-1]
        