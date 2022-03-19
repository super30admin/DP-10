'''

TC: O (nk)
SC: O(nk)

'''
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:        
        dp = [[0 for _ in range(k + 1)] for _i in range(n + 1)]
        
        for i in range(1, n + 1):
            for j in range(1, k + 1):
                dp[i][j] = 1 + dp[i - 1][j] + dp[i - 1][j -1]
                if dp[i][j] >= n:
                    return i
        