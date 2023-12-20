# Time: O(n^3)
# Space: O(n^2) 
# Did it run on Leetcode: yes

# we use dp matrix to build the solutions for single problems and solve the bigger ones, gradually. we ddetermine in each subproblem the possibility of each number being burst last in the end. 
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        if n==0:
            return 0
        dp=[[0 for _ in range(n)]for _ in range(n)]
        
        for le in range(1,n+1):
            # start indx
            
            for i in range(n-le+1):
                j=i+le-1
                maxe=0
                for k in range(i,j+1):
                    #  before + left*curr*right + after
                    before=0
                    if(k!=i):
                        before=dp[i][k-1]
                    after=0
                    if(k!=j):
                        after=dp[k+1][j]
                    left=1
                    if(i!=0):
                        left=nums[i-1]
                    right=1
                    if(j!=n-1):
                        right=nums[j+1]
                    maxe=max(maxe, before + left*nums[k]*right + after)

                dp[i][j]=maxe
        return dp[0][n-1]