"""
Time complexity O(K*N*N) -->O(KN^2)

Space complexity O(KN)

Fill the dp table having 1,2,3,4 floor and find Break and No break and get maximum number. To find the minimum certainity get the minimum between prev and curr dp[i][j]
"""


class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        #K eggs and N floors
        dp=[[0]*(N+1) for j in range(K+1)] #K+1 in row and N+1 in column
        #print(dp)
        #print(K,N)
        for j in range(0,len(dp[0])):
            dp[1][j]=j
        
        for i in range(2,len(dp)): #2,...K+1 row
            for j in range(1,len(dp[0])): # 1 .... range(dp col)
                dp[i][j]=float("inf")
                for l in range(1,j+1): #l....till j (floor window)
                    val=1+ max(dp[i-1][l-1],dp[i][j-l]) #1 attempt + max(Break, No Break)
                    dp[i][j]=min(dp[i][j],val) #min certainity
        
        return dp[K][N]
                