#Time: O(NK^2)
#Space: O(NK)
class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        
        dp = [[0]*(K+1) for i in range(N+1)]
        
        for attempts in range(1,len(dp)):
            
            for eggs in range(1,len(dp[0])):
                
                dp[attempts][eggs] = 1+ dp[attempts-1][eggs] + dp[attempts-1][eggs-1]
                
                if dp[attempts][eggs] >= N:
                    return attempts 
