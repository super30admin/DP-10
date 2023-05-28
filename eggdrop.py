class Solution:
    # for number of attempts varying from 0 to n(no of steps), find out how many number of floors can be explored,sop when dp value reached is equal to no of floors i.e no of floors explored with avavilable attempts is the total no of floors, return the current no of attempts
    # TC-O(NK),SC-O(NK)
    def superEggDrop(self, k: int, n: int) -> int:
        dp=[[0 for i in range(k+1)] for l in range(n+1)]
        attempts=0
        while(dp[attempts][k]<n):
            attempts+=1
            for j in range(1,k+1):
                dp[attempts][j] = 1+dp[attempts-1][j-1]+dp[attempts-1][j]
                # one for current attempt+break+no break
        return attempts
        
