# Time Complexity :O(K*N^2) where K is number of eggs and N is number of floors
# Space Complexity :O(N*K) where K is number of eggs and N is number of floors
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)] for _ in range(k+1)]
        
        for j in range(1, n+1):
            dp[1][j] = j
            
            
        for i in range(2, k+1):
            for j in range(1, n+1):
                dp[i][j] = float('inf')
                for f in range(1, j+1):
                    curr = 1 + max(dp[i-1][f-1], dp[i][j-f])
                    dp[i][j] = min(dp[i][j], curr)
                          
        return dp[k][n]