# Approach DP - Exceeds time limit
"""
TC: O(k * n^2)
SC: O(k * n)
"""
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[float('inf')]*(n+1) for _ in range(k+1)]
        for i in range(k+1):
            dp[i][0] = 0
        for j in range(n+1):
            dp[1][j] = j
        
        for i in range(2, k+1):
            for j in range(1, n+1):
                for start_floor in range(1, j+1):
                    dp[i][j] = min(dp[i][j], \
                                  1 + max(dp[i-1][start_floor -1 ],\
                                          dp[i][j - start_floor])) # no break
                    # min from each permutation of start_foor
                    # 1 + max(break, no break)
        return dp[-1][-1]

    # Approach 2: DP
    """
    TC: O(k * n)
    SC: O(k * n)
    """
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0]*(k+1) for _ in range(n+1)]
        
        for i in range(1, n+1):
            for j in range(1, k+1):
                dp[i][j] = 1 + dp[i-1][j-1] + dp[i-1][j]
            if dp[i][j] >= n: break

        return i