# Time Complexity : O(N*K)
# Space Complexity : O(N*K)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for i in range(k+1)] for i in range(n+1)]
        
        attempt = 0 
        
        while dp[attempt][k] < n:
            attempt += 1
            for i in range(1, len(dp[0])):
                dp[attempt][i] = 1 + dp[attempt-1][i-1] + dp[attempt-1][i]
                
        return attempt
            