# // Time Complexity :O(k*n^2)
# // Space Complexity :O(n^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp=[[0 for i in range(n+1)] for j in range(k+1)]
        for i in range((n+1)):
            dp[1][i]=i
        # take the best of the worst case
        for i in range(2,k+1):
            for j in range(1,n+1):
                dp[i][j]=inf
                for f in range(1,j+1):
                    dp[i][j]=min(dp[i][j],1+max(dp[i-1][f-1],dp[i][j-f]))
        print(dp)
        return dp[k][n]