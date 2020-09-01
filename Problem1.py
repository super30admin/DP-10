"""
time : o(n * k)
space : o(n * k)
"""
class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        
        dp = [[0 for i in range(N+1)]for j in range(K + 1)] # number of floors - columns, number of eggs - rows
        #print(dp)
        
        for i in range(len(dp[0])):
            dp[1][i] = i 
        
        for i in range(2,len(dp)):
            for j in range(1,len(dp[0])):
                dp[i][j] = sys.maxint
                for l in range(1, j+1):
                
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i - 1][l - 1], dp[i][j - l])) #min of max of break and no break case 
                
        return dp[-1][-1]