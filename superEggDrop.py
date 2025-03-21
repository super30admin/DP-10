class Solution:
    # TC : O(nk)
    # SC : O(nk)
    def superEggDrop(self, k: int, n: int) -> int:
        if n == 0 or k == 0:
            return 0
        dp = [[0]*(k+1) for i in range(n+1)]
        attempts = 0
        while dp[attempts][k] < n:
            attempts += 1
            for j in range(1,k+1):
                # cur val = 1 + no break scenario + break scenario
                dp[attempts][j] = 1+dp[attempts-1][j] + dp[attempts-1][j-1]
        return attempts