'''
TC :O(k*n*n) - egg rows * floor cols* (iteration over all floors) to
                find the minimum
                As expected, got Time limit exceeded
SC :O(k*n) - for creating a dp matrix with eggs and floors
'''
class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[float("inf") for _ in range(n+1)] for _ in range(k+1)]
        for i in range(n+1):
            dp[0][i] = 0
        for i in range(0,k+1):
            dp[i][0] = 0
        for i in range(1,n+1):
            dp[1][i] = dp[1][i-1]+1  
        
        for i in range(2,k+1):
            for j in range(1,n+1):
                start, end = 0, j-1
                curr = -float("inf")
                for k in range(1,j+1):
                    dp[i][j] = min(dp[i][j],1+max(dp[i-1][start], dp[i][end]))
                    start+=1
                    end -=1
        return dp[-1][-1]
s = Solution()
print(s.superEggDrop(1,2))
print(s.superEggDrop(2,6))
print(s.superEggDrop(3,14))