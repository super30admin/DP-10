"""
Time complexity O(K*N) -->O(KN)

Space complexity O(KN)

This solution we keep no of attempts and No of eggs and try to find number of floor. when the val in dp array which is no of floor goes gt than given N , we can say that is the minimum certainity.

"""


class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        #K eggs and N floors
        dp=[[0]*(K+1) for j in range(N+1)] #K+1 in row and N+1 in column
        
        attempts=0 #No of attempts worst case is no of floors  (row)
        while(dp[attempts][K]<N): #you can stop if the val in dp array greater than floor
            attempts+=1
            for j in range(1,K+1):
                dp[attempts][j]=1+dp[attempts-1][j-1]+dp[attempts-1][j] #1+Break[attemps left][eggs left ]+No Break[attemps left][eggs left ]
        return attempts
                