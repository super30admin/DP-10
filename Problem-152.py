'''
Leetcode - 887. Super Egg Drop
Time complexity - O(K*N)
space complexity - O(K*N)
Approach - DP
           1) First, we need to create Trys+1 and k+1 matrix 
           2) At each cell we need to find maximum number of floors required for x trys and y eggs.
           3) At particular cell when we reach >= N floors then we stop it.
           4) In the end we need to return trys.
           
'''
class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        dp=[[0 for _ in range(K+1)] for _ in range (N+1)]
        trys=0
        while dp[trys][K]<N:
            trys+=1
            for egg in range(1,K+1):
                dp[trys][egg]=1+dp[trys-1][egg-1]+dp[trys-1][egg]
        return trys
                
            