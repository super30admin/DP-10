# // Time Complexity :O(n^3)
# // Space Complexity :O(n^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[[0 for i in range(n)]for j in range(n)]
        #the length of balloons vary from 1 to n(including n), therefore
        for l in range(1,n+1):
            #starting points vary from 0 to n-len, based on what the length is
            for i in range(0,n-l+1):
                #for each poin j is constant
                j=i+l-1
                #iiterate over each sub element, kth element last to burst
                for k in range(i,j+1):
                    before=0
                    after=0
                    #before
                    if i!=k:
                        before=dp[i][k-1]
                    left=1
                    right=1
                    #right
                    if j!=n-1:
                        right=nums[j+1]
                    
                    #left
                    if i != 0:
                        left=nums[i-1]
                    #end
                    end=nums[k]
                    
                    
                    #after
                    if j!=k:
                        after=dp[k+1][j]
                        
                    dp[i][j]=max(dp[i][j],(before+after+(left*end*right)))
                    
        return dp[0][n-1]