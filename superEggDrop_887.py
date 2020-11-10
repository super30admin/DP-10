# // Time Complexity : O(K*N*N)
# // Space Complexity : O(K*N)
# // Did this code successfully run on Leetcode : No, TLE
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Binary search can't be used as there is a limitation on number of eggs and hence we can't say for sure if after running out of eggs we get our optimal answer or not.
# eg: k=2, n=4 dp matrix: j is floors, i is eggs
# for dp[0][j] and dp[i][0] == 0
# with one egg: you visit each floor to attempt if the egg broke/din't break
# with two eggs: you pick and choose. min(1 attempt (for any floor) + max(Break: dp[#no eggs remaining][floors left to explored], Don't break: dp[#no eggs remaining][floors left to explored])) for each iteration of floor starting points(1,2,3,4) and resetting the eggs at every iteration.

class Solution:
    def superEggDrop(self, K: int, N: int) -> int:
        dp = [[0 for _ in range(N+1)] for _ in range(K+1)]
        
        for j in range(1, N+1):
            dp[1][j] = j
        
        #dp
        for i in range(2, K+1):
            for j in range(1, N+1):
                dp[i][j] = float('inf')
                
                for floor in range(j):
                    dp[i][j] = min(dp[i][j], 1 + max(dp[i-1][floor], dp[i][j-floor-1]))
        
        return dp[-1][-1]

   
# // Time Complexity : upper bounded by O(K*N)
# // Space Complexity : O(K*N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Assumption: The minimum attemps is <= number of floors
# DP matrix: j(eggs), i(max # of attempts), values: no.of floors
# attempt= 1 with 1 egg: 1(current floor) + floors that broke + floors that didn't break
# eg: 1 + B: dp[1-1][0]+ NP: dp[1-1][1] = 1+0+0 = 1
# eg: 2attempts with 1 egg : 1+ B: dp[1][0] + DB: dp[1][1]
# eg: 2eggs, 2 attempts: 1 + B: dp[1][1]+ DB: dp[1][2] if i have 3 floors, and 2 eggs then minimum number of attempts required are 2.
# observation if we get to the number of floors(dp[i][j]) given to us in the dp matrix for given eggs j , return the i-> min # of attempts
# If dp[i][j(given eggs)]>=N: I can cover up until that floor. Hence we can stop at that point in ith index

class Solution:
    
    def superEggDrop(self, K: int, N: int) -> int:
        
        attempts = 0
        dp = [[0 for _ in range(K+1)] for _ in range(N+1)]        
        
        while dp[attempts][K] < N:
            attempts += 1
            for j in range(1, K+1):
                dp[attempts][j] = 1 + dp[attempts-1][j-1] + dp[attempts-1][j]
        
        return attempts

