"""
Problem : 1

Time Complexity : 
DP I - O(k*n^2)
DP II - O(n*k)

Space Complexity : 
DP I & II - O(n^2)
DP III - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Super Egg Drop

# Approach - 1
# Dynamic Programming I

class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        # best of the worst we need to consider
        dp=[[0 for _ in range(n+1)] for _ in range(k+1)]
        for j in range(1,n+1):
            dp[1][j]=j
        for i in range(2,k+1):
            for j in range(1,n+1):
                # j is current numberof floors
                minn=float('inf')
                for f in range(j+1):
                    minn=min(minn,1+max(dp[i-1][f-1],dp[i][j-f]))
                dp[i][j]=minn
        return dp[k][n]


# Approach - 2
# Dynamic Programming II

class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        # best of the worst we need to consider
        dp=[[0 for _ in range(k+1)] for _ in range(n+1)]
        attempts=0
        while dp[attempts][k]<n:
            attempts+=1
            for j in range(1,k+1):
                dp[attempts][j]=1+dp[attempts-1][j-1]+dp[attempts-1][j]
        return attempts
    

# Approach - 3
# Dynamic Programming III

class Solution(object):
    def superEggDrop(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: int
        """
        # best of the worst we need to consider
        dp=[0 for _ in range(k+1)]
        attempts=0
        while dp[k]<n:
            attempts+=1
            diagUp=0
            for j in range(1,k+1):
                temp=dp[j]
                dp[j]=1+diagUp+dp[j]
                diagUp=temp
        return attempts  