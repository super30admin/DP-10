# DP Solution
# Time complexity : O(n*n*k)
# Space complexity : O(n*k)
# Leetcode : Time limit exceeded

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # make a dp array of size n+1 * k+1
        dp = [[0 for _ in range(n+1)] for _ in range(k+1)]
        
        # filling first row
        # fill the row with the value of the floors
        for i in range(1,n+1):
            dp[1][i] = i
        
        # rows
        # traversing through each row starting from 2nd row
        for i in range(2,k+1):
            # cols
            # traverse through all cols starting with 1st
            for j in range(1,n+1):
                # floor
                # filling the values with Infinity as we need to find the min
                dp[i][j] = float('inf')
                
                # go over each floor which ranges from 0 till j+1, as my current floors
                # this is the loop for permutations
                # break - egg-1 and remaining floors below the curr floor
                # no break - same eggs (k) and remaining floors above the curr floor
                for f in range(j+1):
                    # find the max between the break and no break case and add one to it
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i][j-f], dp[i-1][f-1]))
        
        # return the final value calculated in the last index
        return dp[k][n]
