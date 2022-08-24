# TC: O(N^2*k)
# SC:O(N^2)
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)]for _ in range(k+1)]
        
        # populate DP array 1st row jth cols with j
        for j in range(n+1):
            dp[1][j] = j
        
        for i in range(2, k+1):
            for j in range(1, n+1):
                dp[i][j] = float("inf")
                for K in range(1, n+1):
                    dp[i][j] = min(dp[i][j], 1+max(dp[i-1][K-1], dp[i][j-K]))
        return dp[k][n]