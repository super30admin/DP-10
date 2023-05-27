class Solution:
    #TC-O(N^3),SC-0(N^2)
    # consider burstable array as the array of balloons that can only be burst as arrays of length 1,2,....n.Now whenever we solve a problem we can use previous subarray results to solve it.
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        dp=[[0 for i in range(n)]for j in range(n)]
        # indicating length of subarray,i is the start index, j is the end index of the subarray of burstable balloons, k is the last balloon to burst in the burstable array
        for l in range(1,n+1):
            for i in range(0,n-l+1):
                j = i+l-1
                m=float('-inf')
                for k in range(i,j+1):
                    left=0
                    right=0
                    if(i!=k):
                        left=dp[i][k-1]
                    if(j!=k):
                        right=dp[k+1][j]
                    before=1
                    after=1
                    if(i!=0):
                        before=nums[i-1]
                    if(j!=n-1):
                        after=nums[j+1]
                    m=max(m,left+before*nums[k]*after+right)
                dp[i][j]=m
        return dp[0][n-1]
                