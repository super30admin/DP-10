# DP Space optimized
# Time complexity : O(n*k)
# Space complexity : O(k)
# Leetcode : Solved and submitted

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # maintain a dp matrix of size k
        dp = [0 for _ in range(k+1)]
        # n is number of attempts here
        attempts = 0
        
        # we traverse until the value of dp at any index is less than n
        while dp[k] < n:
           # increment the attempts
            attempts += 1
            
            # make a deep copy of the dp matrix as we'll overwrite this value if not for a copy
            temp = dp[:]
            for i in range(1,k+1):
                # update the dp at particular index with the break and no break cases
                dp[i] = 1 + temp[i] + temp[i-1]
        
        # return the attempt at which we crossed n floors
        return attempts
