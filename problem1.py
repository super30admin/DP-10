#time O(KN)
#space O((N+1)*(K+1))
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0]*(k+1) for _ in range(n+1) ] # (n+1) x (k+1)
        for i in range(n+1): dp[i][1] = i
        for j in range(k+1): dp[0][j] = 0

        for j in range(2, k+1): # j eggs
            x = 1
            for i in range(1, n+1): # i floors
                while x <= i and dp[i-x][j] > dp[x-1][j-1]: x += 1
                dp[i][j] = 1 + dp[x-1][j-1]
        return dp[n][k]