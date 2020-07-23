#Time Complexity : O(N^3)
#Space Complexity : O(N^2)
#Approach
#1. Initialiaze a dp array of nxn size.
#2. Iterate to get the length of the subaray we are dealing with. 
#3. Then iterate a for loop to get  first index and last index in subaray.
#4. The value we are fiiling the dp array with is before+left*balloon*right+after, 
    # And k would iterated in that subarray considered and we will the values in dp. 
#5. While filling the dp array we consider the maximum value obatined 
#6. Return dp[0][n-1]
def maxCoins(self, nums: List[int]) -> int:
        if len(nums) ==0:
            return 0
        n=len(nums)
        dp= [[0 for r in range(n)] for l in range(n)]
        for l in range(1,n+1):
            for i in range(0,n-l+1):
                j=i+l-1
                for k in range(i,j+1):
                    left=1
                    right=1
                    if i !=0:
                        left=nums[i-1]
                    if j!=n-1:
                        right=nums[j+1]
                    before=0
                    after=0
                    if k!=i:
                        before=dp[i][k-1]
                    if k!=j:
                        after=dp[k+1][j]
                    dp[i][j]=max(dp[i][j],before+left*nums[k]*right+after)
        return dp[0][n-1]
