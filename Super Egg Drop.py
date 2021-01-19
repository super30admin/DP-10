# Time:- k*n
# Space:- K*n
# Approach= The idea is to check the no. of floors we can check if we had k eggs and any no. of attempts. If while checking this we can get to the N floors given in the problem we have found the no. of attempts we have to make. 
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        # with 0 attempts we can't check any floor
        dp = [[0]*(K + 1) for i in range(N + 1)]
        
        for m in range(1,N+1):
            for k in range(1,K+1):
                # at the mth attempt and with k eggs we can check 1+[m-1][k-1]+[m-1][k] floors
                dp[m][k]=dp[m-1][k-1]+dp[m-1][k]+1
            # if the no. of floors we can check the mth attempt exceeds/equals the no. of floors we had to check originally we return the m attempts
            if dp[m][K]>=N:
                return m