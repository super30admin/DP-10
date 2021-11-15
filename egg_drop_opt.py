# // Time Complexity :O(n^2)
# // Space Complexity :O(n^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp=[[0 for i in range(k+1)] for j in range(n+1)]
        attempts=0
        while dp[attempts][k]<n:
            attempts+=1
            for j in range(1,k+1):
                dp[attempts][j]=1+dp[attempts-1][j-1]+dp[attempts-1][j]
                
        return attempts
        