"""
Problem : 2

Time Complexity : O(n^3)
Space Complexity : O(n^2)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Burst Balloon

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n=len(nums)
        dp=[[0 for _ in range(n)] for _ in range(n)]

        for l in range(1,n+1):
            # start index of burstible array
            for i in range(n-l+1):
                # end
                j=i+l-1
                maxx=float('-inf')
                for k in range(i,j+1):
                    left=0
                    right=0
                    if i!=k:
                        left=dp[i][k-1]
                    if j!=k:
                        right=dp[k+1][j]
                    before=1
                    after=1
                    if i!=0:
                        before=nums[i-1]
                    if j!=n-1:
                        after=nums[j+1]
                    maxx=max(maxx,left+after*nums[k]*before+right)
                dp[i][j]=maxx

        return dp[0][n-1]

