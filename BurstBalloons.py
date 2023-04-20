#All TC on leetcode passed

class Solution:
    def maxCoins(self, nums: List[int]) -> int:

        #Here we try all combinations of balloon bursting for different length combinations and store them in dp array.
        #Time complexity - O(n^3) - as 3 for loops are required to compute dp array
        #Space complexity - O(n^2) - DP array of n*n
        n = len(nums)
        dp = [[0]*n for i in range(n)]

        for l in range(1, n+1): #l varies from 1,2,3,...n
            
            for i in range(0, n-l+1): #i varies from 0 to n-l
                j = i+l-1     #j points to last term for current l 
                
                for k in range(i,j+1): #k varies from i to j trying each element to be end burst
                    
                    #before + left*cur*right + after
                    
                    left = 1
                    right = 1
                    before = 0
                    after = 0

                    if i!=0: 
                        left = nums[i-1] #left term holds un-burst balloon val to left of k

                    if j!=n-1:
                        right = nums[j+1] #right term holds un-burst balloon val to right of k

                    if k!=i:
                        before = dp[i][k-1] #before term holds burst ballon value from dp array to left of k

                    if k!=j:
                        after = dp[k+1][j] #after term holds burst ballon value from dp array to right of k

                    dp[i][j] = max(dp[i][j], before + (left*nums[k]*right) + after)

        return dp[0][n-1]
