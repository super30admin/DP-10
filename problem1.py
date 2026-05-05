# problem 1 

# https://leetcode.com/problems/super-egg-drop/


class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0]*(n+1) for _ in range(k+1)]
        for i in range(1,n+1):
            dp[1][i] = i
        for i in range(2,k+1):
            for j in range(1,n+1):
                dp[i][j] = float('inf')
                low = 1 
                high = j 
                while (low<=high):
                    mid = low +(high-low)//2
                    breakEgg = dp[i-1][mid-1]
                    noBreakEgg = dp[i][j-mid]
                    dp[i][j] = min(dp[i][j],1+max(breakEgg,noBreakEgg))
                    if breakEgg > noBreakEgg:
                        high = mid-1
                    else:
                        low = mid+1
        return dp[k][n]