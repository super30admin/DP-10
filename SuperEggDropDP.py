'''
TC O(n*k) where n and k are number of attempts and number of eggs
            respectively
SC O(n*k) - for creating a dp matrix with attempts and eggs
'''
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
        attempts = 0
        while (dp[attempts][k]< n):
            attempts +=1
            for i in range(1,k+1):
                dp[attempts][i] = 1+dp[attempts-1][i-1]+dp[attempts-1][i]
        return attempts
s = Solution()
print(s.superEggDrop(1,2))
print(s.superEggDrop(2,6))
print(s.superEggDrop(3,14))