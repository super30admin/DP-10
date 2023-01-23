class Solution:
    def superEggDrop(self, k: int, n: int) -> int:

        ## approach 2:
        ## T.C = O(n.k)
        ## T.C = O(n.k)

        dp = [[0]*(k+1) for i in range(n+1)]
        attempts = 0
        j = 0
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1, k+1):
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j]
        
        return attempts

        ## approach 1: gives TLE
        dp = [[0]*(n+1) for i in range(k+1)]

        for i in range(n+1):
            dp[1][i] = i
        
        for i in range(2, k+1):
            for j in range(1, n+1):
                dp[i][j] = float('inf')
                for f in range(j + 1):
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][f-1], dp[i][j-f]))
        
        
        # for i in dp:
        #     print(i)

        return dp[-1][-1]