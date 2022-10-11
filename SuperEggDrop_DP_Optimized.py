# Dp Optimized
# Time complexity : O(n*k)
# Space complexity : O(n*k)
# Leetcode : Solved and submitted

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # make a dp matrix of size k+1 * n+1
        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
        
        # we are using the number of attempts that we can have, for which we can find the max number of floors
        attempts = 0
        
        # we traverse and calculate the matrix until we get a value lesser than n
        while dp[attempts][k] < n:
            # increment the row number
            attempts += 1
            
            # we need to calculate for each egg
            for i in range(1,k+1):
                # add the values of break and no break case by adding 1 for each attempt
                dp[attempts][i] = 1 + dp[attempts-1][i] + dp[attempts-1][i-1]
        
        # at any point we reach the number of floors, we return the attempts
        return attempts
