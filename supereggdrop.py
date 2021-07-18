# class Solution:
#     def superEggDrop(self, k: int, n: int) -> int:
#     # def superEggDrop(self, K: int, N: int) -> int:
#
#         # rows - k
#         # cols - n
#         allowed = 0
#         dp = [[0]*(k+1) for _ in range(n+1)]
#
#         while dp[allowed][k] < n:
#             allowed += 1
#             for j in range(1, k+1):
#                 dp[allowed][j] = 1+dp[allowed-1][j-1] +dp[allowed-1][j]
#
#         return allowed



## hello
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(k + 1)]

        for i in range(1, n+1):
                dp[1][i] = i

        for i in range(2, k+1):
                for j in range(1, n+1):
                    dp[i][j] = float('inf')
                    for floor in range(1,j+1):
                        dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][floor - 1], dp[i][j - floor]))
        print(dp)
        return dp[-1][-1]




#
# dp = [[0]*(n+1) for _ in range(k+1)]
#
#         for i in range(1, n+1):
#             dp[1][i] = i
#
#         for i in range(2, k+1):
#             for j in range(1, n+1):
#                 dp[i][j] = float('inf')
#                 for floor in range(1,j+1):
#                     dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][floor - 1], dp[i][j - floor]))
#         print(dp)
#         return dp[-1][-1
