#Time Complexity: O(N^2*k)
#Space complexity:O(N^2)

class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)] for _ in range(k+1)]
        
        for j in range(n+1):
            dp[1][j] = j
        
        for i in range(2, k+1):
            for j in range(1, n+1):
                dp[i][j] = float("inf")
                for K in range(1, n+1):
                    dp[i][j] = min(dp[i][j], 1+max(dp[i-1][K-1], dp[i][j-K]))
        return dp[k][n]
        
        
        
        
        
        
        
       
        
        
        '''
        0           1               2           3               4                    5              6
        
    0   0    ------------------------------------------------------------------------------------------
    
    1   0           1               2           3               4                   5               6
    
    2   0           1               2           2
        
        
        min(1+max(dp[1][0], dp[2][3]), 1+max(dp[1][1], dp[2][2]), 1+max(dp[1][2], dp[2][1]), 1+max(dp[1][3], dp[2][0]))
        
        
        -
        -
        -3
        -3
        
        
        '''
        
