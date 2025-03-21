class Solution:
    #k^n^n approach gives tle when we compute attempts for each possible floor with each possible egg
    # def superEggDrop(self, k: int, n: int) -> int:
    #     dp=[[0 for _ in range(n+1)]for _ in range(k+1)]
    #     for j in range(1,n+1):
    #         dp[1][j]=j
    #     for i in range(2,k+1):
    #         for j in range(1,n+1):
    #             dp[i][j]= float('inf')
    #             for t in range(1,j+1):
    #                 dp[i][j]= min(dp[i][j],1+ max(dp[i-1][t-1],dp[i][j-t]))
    #     return dp[k][n]
#this approach is using logic of counting floors based attempts and floors
#time: O(k*n)
#space: O(k*n)
    def superEggDrop(self, k: int, n: int) -> int:

        dp=[[0 for _ in range(k+1)]for _ in range(n+1)]

        for i in range(1,n+1):
            for j in range(1,k+1):
                dp[i][j]=1+dp[i-1][j-1]+ dp[i-1][j]
                if dp[i][j] >=n:
                    return i
        return float('inf')



                

        
