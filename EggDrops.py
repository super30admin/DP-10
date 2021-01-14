class Solution:
    def superEggDrop(self, K: int, N: int) -> int: 
        dp = [[0]*(N+1) for _ in range(K+1)]
        for j in range(len(dp[0])):
            dp[1][j] = j
            
        print(dp)
        # i stands for eggs
        # j stands for floors
        for i in range(2,len(dp)):
            for j in range(1,len(dp[0])):
                    dp[i][j] = float("inf")
                    for k in range(1,j+1):
                        #break 
                        #egg -1 and but investigate lower
                        #no break
                        #egg remains the same but investigate upper
                        dp[i][j] = min(dp[i][j],1+max( dp[i][j-k], dp[i-1][k-1]) ) 
                    
        return dp[-1][-1]
Time : O(KN2)
Space: (KN)
